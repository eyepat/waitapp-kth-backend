package se.kth.ki.waitapp.core.interfaces.service;

import io.smallrye.mutiny.Uni;

public interface IExporterService {

    Uni<byte[]> exportData(String format);
}
