package se.kth.ki.waitapp.core.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.reactive.mutiny.Mutiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.GenericTestWithAuth;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericService;
import se.kth.ki.waitapp.core.model.IBaseModel;
import se.kth.ki.waitapp.dto.IBaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

abstract class GenericServiceTest<T extends IBaseModel, TDTO extends IBaseDTO, 
            TSERVICE extends IGenericService<T, TDTO>, 
            TMAPPER extends IGenericMapper<T, TDTO>, 
            TREPO extends IGenericRepository<T>> 
            extends GenericTestWithAuth {

    SecurityIdentity identity;
    TMAPPER mapper;
    TREPO repository;
    JsonWebToken jwt;
    Mutiny.SessionFactory sf;
    UUID mockUUID = UUID.randomUUID();

    protected TSERVICE service;
    protected Class<T> modelClass;
    protected Class<TDTO> dtoClass;
    protected Class<TREPO> repositoryClass;
    protected Class<TMAPPER> mapperClass;

    protected GenericServiceTest(Class<T> modelClass, Class<TDTO> dtoClass, Class<TREPO> repositoryClass, Class<TMAPPER> mapperClass) {
        this.modelClass = modelClass;
        this.dtoClass = dtoClass;
        this.repositoryClass = repositoryClass;
        this.mapperClass = mapperClass;
    }

    protected abstract TSERVICE createService(Mutiny.SessionFactory sessionFactory, JsonWebToken jwt);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        identity = mock(SecurityIdentity.class);
        mapper = mock(mapperClass);
        repository = mock(repositoryClass);
        jwt = mock(JsonWebToken.class);
        sf = mock(Mutiny.SessionFactory.class);

        assertNotNull(sf, "JsonWebToken (jwt) is null, injection might be failing");
        assertNotNull(sf, "SessionFactory (sf) is null, injection might be failing");

        when(sf.withSession(any())).thenAnswer(invocation -> {
            Function<Mutiny.Session, Uni<?>> work = invocation.getArgument(0);
            Mutiny.Session mockSession = mock(Mutiny.Session.class);
            return work.apply(mockSession);
        });

        service = createService(sf, jwt);

        when(identity.isAnonymous()).thenReturn(false);
        when(identity.hasRole("admin")).thenReturn(true);

        when(jwt.getSubject()).thenReturn(mockUUID.toString());
        when(jwt.getClaim("sub")).thenReturn(mockUUID.toString());
    }

    @Test
    void testFindAll() {
        @SuppressWarnings("unchecked")
        PanacheQuery<T> mockQuery = Mockito.mock(PanacheQuery.class, Mockito.RETURNS_DEEP_STUBS);
        when(repository.findAll()).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(Uni.createFrom().item(List.of()));

        Uni<List<TDTO>> result = service.findAll();

        assertNotNull(result);
        List<TDTO> resultList = result.await().indefinitely();
        assertNotNull(resultList);
        assertEquals(0, resultList.size());
    }

    @Test
    void testFindById() {
        T model = Mockito.mock(modelClass, Mockito.RETURNS_DEEP_STUBS);
        TDTO dto = Mockito.mock(dtoClass, Mockito.RETURNS_DEEP_STUBS);
    
        when(model.isPersistent()).thenReturn(true);
    
        @SuppressWarnings("unchecked")
        PanacheQuery<T> mockQuery = Mockito.mock(PanacheQuery.class, Mockito.RETURNS_DEEP_STUBS);
        when(repository.find("WHERE id = ?1", 1L)).thenReturn(mockQuery);
        when(mockQuery.firstResult()).thenReturn(Uni.createFrom().item(model));
        when(mapper.toDTO(model)).thenReturn(dto);
    
        Uni<Optional<TDTO>> result = service.findById(1L);
    
        assertNotNull(result);
        Optional<TDTO> resolvedResult = result.await().indefinitely();
        assertTrue(resolvedResult.isPresent(), "Expected result to be present, but it was empty");
        assertEquals(dto, resolvedResult.get());
    }

    @Test
    void testCreate() {
        TDTO dto = Mockito.mock(dtoClass, Mockito.RETURNS_DEEP_STUBS);
        T model = Mockito.mock(modelClass, Mockito.RETURNS_DEEP_STUBS);

        when(mapper.toEntity(dto)).thenReturn(model);
        when(repository.persistAndFlush(model)).thenReturn(Uni.createFrom().item(model));
        when(mapper.toDTO(model)).thenReturn(dto);

        Uni<TDTO> result = service.create(dto);

        assertNotNull(result);
        TDTO resolvedResult = result.await().indefinitely();
        assertEquals(dto, resolvedResult);
    }
}
