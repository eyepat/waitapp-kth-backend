package se.kth.ki.waitapp.init.seed;

import java.util.List;

import org.hibernate.reactive.mutiny.Mutiny;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IRecipeRepository;
import se.kth.ki.waitapp.core.model.recipe.Recipe;

@ApplicationScoped
public class RecipeSeeder extends GenericSeeder<Recipe> {

    @Inject
    public RecipeSeeder(IRecipeRepository repository, Mutiny.SessionFactory sf) {
        super(repository, sf, List.of(
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/apelsin-och-rosegravad-lax")
                        .cookingTime(20)
                        .description("Apelsin och rosépeppar är mycket gott till gravad lax. Perfekt på en buffé.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2ik2oVhW7YSOAUdCcio16Y/8aa901d4b18d7445ae466febd43f3106/Apelsin-och_rosegravad_lax_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Apelsin- och roségravad lax").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/bakad-apelsinmarinerad-frukt")
                        .cookingTime(35)
                        .description("Bakad apelsinmarinerad frukt med vaniljglass är en härlig höstdessert.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7CJrOMzF0gWCfbo2C28iGq/0342d2ed64f00be83d158de86f3e89fe/Bakad_apelsinmarinerad_frukt_med_vaniljglass_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Apelsinmarinerad frukt med glass ").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/burgare-med-tillbehor")
                        .cookingTime(30)
                        .description(
                                "Den här perfekta burgaren är gjord på mager nötfärs och serveras i hamburgerbröd med smakfull dressing och picklad rödlök. Rotfruktsfries är gott till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3Qnp5qRo71ZqiKtmbaEIGN/5e7a5febb8047684c76e74441b60a2d9/Burgare_med_currydressing_820x820.jpg?w=820&h=820&q=90&fm=png")
                        .title("Burgare med picklad rödlök").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/crostini-med-olika-toppingar")
                        .cookingTime(25)
                        .description(
                                "Perfekt till minglet före kräftskivan på sommaren men passar lika bra på vintern till nyårsafton till exempel.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4t4ZmAmXhqjcnAfaAG7F1p/7f584562949da3a1e789dff791f4ef5d/Recept_-_Crostini_med_olika_toppingar_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Crostini med olika toppingar").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/fisk-med-mandeltacke")
                        .cookingTime(40)
                        .description(
                                "Fisk med mandel känner många igen från skolan. Det är jättegott och enkelt att laga. Bra mat till hela familjen!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3fNsbfRU9gM1Z7lCQMZDUZ/e9b66e29ac62e416ad192ed60c2a1015/Recept_-_Fisk_med_mandelt__cke_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Fisk med mandeltäcke").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/grillade-kycklingfileer-med-sparrissallad-samt-tzatziki")
                        .cookingTime(45)
                        .description(
                                "När det är grillsäsong kan du testa de här snabblagade kycklingfiléerna. Gott med den saftiga gröna salladen och tzatziki till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6m1witoRjs5kLQ9EpfXA2Z/ab30caa8dfdfb5ae1f688267829cb8c6/Grillade_tunna_kycklingfil__er_med_sparrissallad_samt_tzatziki_desktop.png?w=1080&h=715&q=90&fm=png")
                        .title("Grillade kycklingfiléer med sparrissallad och tzatziki").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/grillade-tunna-kycklingfileer-med-rucolasas")
                        .cookingTime(35)
                        .description(
                                "Underbart god grillad sommarrätt som passar bra med färskpotatis, sparris och sallad.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1Ey5eKb9DZLc5bhnDRgkNa/28e5064ece3d1f13d8cfe5c3e4ac79b6/Recept_-_Grillade_tunna_kycklingfil__er_med_rucolas__s_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Grillade tunna kycklingfiléer med ruccolasås").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/gulaschsoppa").cookingTime(90)
                        .description("Smakrik vintersoppa med båda kött och rotfrukter.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6DURxamOQzZrU80HOILLE2/b5e459492ed5794784505723449f2b0d/Recept_-_Gulaschsoppa_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Gulaschsoppa").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/honungsglaserad-brysselkal")
                        .cookingTime(20).description("Honungsglaserad brysselkål är en härlig grön rätt på julbordet.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7lieoxvxbrvMxsN2ReYBOC/4c85d4127d76d7f94415bd41971dd466/Recept_-_Honungsglaserad_brysselk__l_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Honungsglaserad brysselkål").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kalops-pa-alg").cookingTime(90)
                        .description("Kalops på älg passar bra som värmande mat på hösten.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1irb6Z7ov3CCJGGTCyA7uT/7b01b7ffe5b7e03eac0c8a855ebcf4a9/Recept_-_Kalops_p_____lg_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kalops på älg").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/laxburgare-med-mangosalsa-och-soja-ingefarsmajonnas")
                        .cookingTime(45)
                        .description(
                                "Lax är tacksam att mixa till färs och göra burgare av. Dessutom blir det så gott.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1lcc0UpM6SQ3J3Aek7TqzU/b0767ac70a7c77cf6c446d7975545c64/laxburgare-med-mangosalsa-och-soja-ingefarsmajonnas-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Laxburgare med mangosalsa och soja-ingefärsmajonnäs").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/miso-ingefarsmarinerade-rotfrukter")
                        .cookingTime(60)
                        .description(
                                "Perfekt mättande varm sallad med rostade rotfrukter, som passar utmärkt den kallare årstiden.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5OMhlqsqDmCJdPAA0Ck6Pp/8e9e6c98eee0019c3252e637037bf671/Recept_-_Miso-ingef__rsmarinerade_rostade_rotfrukter_till_lax_eller_kyckling_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Rostade rotfrukter med miso och ingefära").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/moules-marinieres-kokta-blamusslor")
                        .cookingTime(20)
                        .description(
                                "Enkelt, gott och hälsosam mat är musslor som är enklare än vad man tror att tillaga. Det här är ett grundrecept som du kan använda som bas för soppa, pastasås med mera.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/I4N7LkU9qkLDyOIZ5CVo0/26cdd279fff757677b6be15c36c600f1/kokta-blamusslor-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Moules marinières - Kokta blåmusslor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/musselpasta").cookingTime(45)
                        .description(
                                "Musslor är lite pilligt men ack så gott och väl värt besväret. Både god och nyttig mat. Pröva vårt recept!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7l3XiTMnqRf4mRHTEHDCDC/0e09be4f3b9d3777bd546bc7f0837492/Musselpasta_820x820.jpg?w=820&h=820&q=90&fm=png")
                        .title("Somrig musselpasta").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/mustiga-hamburgerbrod")
                        .cookingTime(105)
                        .description(
                                "Det blir så mycket godare med hembakta hamburgerbröd. De här är dessutom fiberrika och får fin smak av både dinkel och graham.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7tP5IEPMrTLnrvORuilPnb/eba3411b899ce30d00a3065021ea62b8/mustiga-hamburgerbrod-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Mustiga hamburgerbröd").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/nyarsmingel-tilltugg")
                        .cookingTime(45)
                        .description("Små fina tilltugg som passar till nyårsdrinken före maten eller till tolvslaget.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2aKurwhz8rFhtEopoOFddQ/5e22faa071e4fd37602030a392cecbea/Recept_-_Ny__rsmingel_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Nyårsmingel - tilltugg").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/pavlovatarta-med-jordgubbar-pistagemandel-och-lime")
                        .cookingTime(25)
                        .description(
                                "Pavlovatårta med jordgubbar, pistagemandel och lime. Toppen till sommarens alla fester!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6SyNziH820KVjMGhDa24WS/766e40c86b9d44a8bf7e04eb60b34e93/Pavlova-t__rta-med-jordgubbar_1080x715.jpg?w=1080&h=715&q=90&fm=png")
                        .title("Pavlovatårta med jordgubbar").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/picklad-rodlok").cookingTime(10)
                        .description("Gott på hamburgare av kött, bönor eller kyckling men även till andra kötträtter.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1aKV71lNmnL0VCPpyQmxC2/7c59cda7a081d8d5cc3880d7dbe67c28/Recept_-_Picklad_r__dl__k_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Picklad rödlök").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tonfiskpizza").cookingTime(75)
                        .description("Det är gott med tonfisk på pizzan. Lite fullkornsmjöl i degen gör den mustig.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1qDNsWni81TXmvNXb3aDu4/824cb86408e4567d63068f4624810fe9/Recept_-_Tonfiskpizza_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tonfiskpizza").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/potatis-och-purjolokssoppa-med-knaprigt-strossel")
                        .cookingTime(30)
                        .description(
                                "Vardag blir fest med en soppa med krispigt strössel av bröd, grönkål och citronskal.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5YWoDxixdmZfqcCYI50ktA/b4bed8eb9b4c6b4da5238c9fd3418613/Recept_-_Potatis-_och_purjol__kssoppa_med_knaprigt_str__ssel_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Potatis- och purjolökssoppa ").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/ramen-nudelsoppa-med-kyckling")
                        .cookingTime(45)
                        .description(
                                "Ramen är japansk nudelsoppa som kan göras enkel eller mer arbetad med hemkokt buljong. Här får du en enkel variant. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2IKti2rbFXz90Vwcl5jWMP/d6e4524e3844be05b91db56f8fdbcd64/Recept_-_Ramen_____nudelsoppa_med_kyckling_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Ramen - nudelsoppa med kyckling").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/rodbetssallad-med-chevre-valnotter")
                        .cookingTime(50)
                        .description(
                                "Rödbetssallad med chèvre och kryddstekta valnötter passar fint till julbordet eller som vintersallad.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6FbiqwcVWOmj8ETKniRYhZ/6b9fc167f69ce8267d3dd4e1d8879333/R__dbetssallad_med_ch__vre_och_kryddstekta_valn__tter_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Rödbetor med chèvre och valnötter").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/rostad-potatissallad-med-ortolja")
                        .cookingTime(35)
                        .description("Perfekt att servera till grillkvällen, midsommarbuffén eller med lax.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/Hp55eGtZ7YuvgKRCLjPla/8d0d8d9ad840fb6584decaf504678602/rostad-potatissallad-med-ortolja-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Rostad potatissallad med örtolja").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/sallad-med-snabbgravad-och-stekt-lax")
                        .cookingTime(45)
                        .description("Sallad med lax till buffébordet. Laxen kan snabbgravas innan man steker den.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/h0OJeZ8xs7Vrfa7PlBaIc/17e048419db9eb372b4651cadf597389/Sallad_med_snabbgravad_och_stekt_lax_Ddesktop.png?w=820&h=820&q=90&fm=png")
                        .title("Sallad med snabbgravad och stekt lax").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/svamp-och-potatisbullar-samt-kalsallad-med-lingon")
                        .cookingTime(60)
                        .description(
                                "Potatisbullar med svamp passar bra under svampsäsong. Servera med kålsallad och lingon. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6RTESYpLTSGSGcaKRo4ml8/c2550adef2da80c38f3595b6afe10b21/svamp-och-potatisbullar-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Svamp- och potatisbullar och kålsallad ").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tonfisksallad-i-salladsblad")
                        .cookingTime(20)
                        .description("Härlig festlunch med bröd till eller som förrätt en varm sommardag.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7t0CCVz5XZ0SY7kpNvCaN7/5a751da4ad945d972ae9c601ec7c2bc8/Tonfisksallad_i_salladsblad_820x820.jpg?w=820&h=820&q=90&fm=png")
                        .title("Tonfisksallad i salladsblad").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tre-sorters-tilltugg-till-nyar")
                        .cookingTime(45)
                        .description("Perfekt tilltugg men även som alternativ till förrätt. Härlig festmat!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4AB2nEP7FH5EjLrgRc2yGR/0806874ee79c0e49777cb3055bedf8f6/Recept_-_Tre_sorters_tilltugg_till_ny__r_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tre sorters tilltugg till nyår").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tuna-melt-varm-tonfiskmacka")
                        .cookingTime(20).description("Det är en varm tonfiskmacka med mycket smak.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2O1TXWFZ4p5pv7J2UIOctD/2a34b07f5264018a045fdb03f1e60a08/Recept_-_Tuna_Melt_____varm_tonfiskmacka_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tuna Melt - varm tonfiskmacka").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/utflyktsmackor-med-stekt-agg-och-tomater")
                        .cookingTime(15).description("En god äggmacka att ta med i skidspåret eller på långpromenaden.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/SRLu2bxXYwin5PNiAnbyk/e709a39fc57d7bd618335ac4af1dbc2c/Recept_-_Utflyktsmackor_med_stekt___gg_och_stekta_tomater_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Utflyktsmackor med stekt ägg och stekta tomater").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/zucchinipasta-med-rucolapesto")
                        .cookingTime(30)
                        .description("En riktigt grön pasta som får ordentligt med smak av rucolapeston.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/41zOstVlpBzY241H782MeD/cd0e97d00ba8233d696aa07065a52b18/Recept_-_Zucchinipasta_med_rucolapesto_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Zucchinipasta med rucolapesto").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/lattsockrad-appelkram")
                        .cookingTime(20)
                        .description(
                                "Kräm gjord på äpple. God varm eller kall med keso, mjölk eller vegetabiliskt alternativ till. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1h5cG5C7jgAVSZDgpXC4aG/d04c3dcd6fc53e784567dba3fc7fc2d5/L__ttsockrad___ppelkr__m_desktop__1_.png?w=820&h=820&q=90&fm=png")
                        .title("Lättsockrad äppelkräm").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/falafel-med-tillbehor")
                        .cookingTime(45)
                        .description(
                                "Det är mycket lättare än vad man tror att göra egna falafel. Här är dessutom en enklare variant där man steker dem istället för friterar. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1IUloZfZoQqUvplEx0sLFM/4dd63923dbf207085b953750b7742736/Recept_-_Falafel_med_tillbeh__r_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Falafel med tillbehör").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kalpudding-med-kyckling")
                        .cookingTime(70)
                        .description("Kålpudding med kycklingfärs är en husmansklassiker lagad på ett nytt sätt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4gZwvmP3JIEiU2zHhD1Mqy/6fcbeea12eca44170b065c7598133bab/K__lpudding_med_kycklingf__rs_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Kålpudding med kycklingfärs").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/grundrecept-tomatsas-till-pizza")
                        .cookingTime(30)
                        .description(
                                "En god tomatsås är enkelt att göra. Den här såsen är perfekt till pizza, pasta, kyckling, fisk med mera.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/lYapxMy8jmH8d3c6daTZy/610b69d4db9eb0626462be02b329c3cd/Recept_-_Grundrecept_tomats__s_till_pizza_m_m_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Grundrecept tomatsås till pizza m m").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/grillade-gronsaker-kott-oregano-olja")
                        .cookingTime(50).description("Låt grillade grönsaker ta mer plats på tallriken.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4Vwj6DiLMkZUcn9Gsbwsv1/5b9f55764673f1209ae004850bbcb291/Grillade_gr__nsaker__grillat_k__tt_och_oregano-olja_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Grillade grönsaker och kött").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/kesosmorgas-med-tonfisk-samt-fruktsallad")
                        .cookingTime(15)
                        .description(
                                "Kesosmörgås med tonfisk samt liten fruktsallad passar bra som frukost eller som mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6B5pmvSkdNEfnzkgOTaiuf/0126897df0489d963319a0b228ef20bb/Recept_-_Kesosm__rg__s_med_tonfisk_samt_liten_fruktsallad_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kesosmörgås med tonfisk och fruktsallad").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tonfiskpaj-med-oliver")
                        .cookingTime(90).description("Det går utmärkt att baka pajdeg med olivolja.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/jcWqJzsfYQodG5dwUkGaB/d907b27e7b4eb003e173e41fe0978ad4/Recept_-_Tonfiskpaj_med_oliver_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tonfiskpaj med oliver").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tonfiskpasta-express")
                        .cookingTime(15)
                        .description("Ibland har man så bråttom att hinna laga mat känns oöverstigligt. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/40AbHnuNcQss2cLkk5uX9z/79ea15fcac5c68e93b1036f2ff11e18e/Recept_-_Tonfiskpasta_express_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tonfiskpasta express").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tre-bra-mackor-fran-havet")
                        .cookingTime(10)
                        .description(
                                "Det här är exempel på perfekta mellanmål som mättar bra. Slösa med grönsaker på mackan och du blir mätt längre. Du kan välja dina favoritgrönsaker, det här är bara förslag.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6yuVWWWiQZQ3lqpYUj1pY0/61fcd176c4759fc905ceeada34a62fd5/Recept_-_Tre_bra_mackor_fr__n_havet_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tre bra mackor från havet").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/alggryta-med-rotfrukter-katrinplommon")
                        .cookingTime(90).description("Gör en mättande gryta med älgkött och rotfrukter.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1K3rQ1U16khreUjHXxl7MI/63c087036b01bdb9d2fd599cc8bbeb43/alggryta-med-rotfrukter-och-katrinplommon-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Älggryta med rotfrukter och katrinplommon").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/algfarsburgare-med-savoj-cole-slaw")
                        .cookingTime(45)
                        .description(
                                "Älgfärsburgare som serveras med en cole slaw på savojkål samt stekta äpplen och lök.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5SHrWFnZj1vJMM9plhLf5m/6bac16c0ce08a0e5c7ca813bc7050d4f/__lgf__rsburgare_med_savoj-cole_slaw_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Älgfärsburgare med savoj-cole slaw").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/avokadomacka-x-3").cookingTime(10)
                        .description(
                                "Avokado är toppen när man är hungrig. Här är tre härliga helgfrukost-, eller lunchmackor. Perfekt till brunch också.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3K4Or4cT6MT5kYeFRKFPwU/e9cea7dd1de9778ac3472eab6c25d62b/Recept_-_Avocadomacka_x_3_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Avokadomacka x 3").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/sotpotatis-mac-and-cheese-med-frasig-topping")
                        .cookingTime(80)
                        .description("Mac-and-cheese med sötpotatis och spenat gör rätten mindre mastig.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2dLKW6KP9yawCEBpv8MGg6/79907f0501b7fce2d0a7a78bf8aaa3ac/macncheese-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Sötpotatis-mac and cheese").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/sallad-med-tofu-avokado-blabar")
                        .cookingTime(25)
                        .description(
                                "Sallad med stekt tofu, avokado, blåbär och honungsvinägrett. Härlig sallad med mycket smak och vackra färger.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/73CwiO6e5qknz5D748ZJwj/c48bcf07f527d91b09f684cb6484975c/Sallad_med_stekt_tofu__avokado__bl__b__r_och_honungsvin__grett_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Sallad med tofu, avokado och blåbär").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/lingonsmoothie-bowl-med-kanel-och-kardemumma")
                        .cookingTime(10)
                        .description(
                                "Hemmagjord smoothie med lingon, kanel och kardemumma. Lingon är Nordens eget superbär.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2hz6uGmQod3BZVLtPJ3sja/2f350b57f48e8d69873c286ac2f5940b/Lingonsmoothie_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Smoothiebowl med lingon").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/pasta-bonor-frostrossel-parmesan")
                        .cookingTime(35).description("En snabbpasta som passar bra mitt i veckan.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/75ANaXqVLgNZ3ugNsE6PaK/8c4ab6d835d4c50e8d9525ac41b8a687/Pasta_med_mycket_gr__nt__b__nor__fr__str__ssel_och_parmesan_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Pasta med mycket grönt och bönor").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/snabb-avokadoglass-med-matcha-te-och-pistagemandel")
                        .cookingTime(10)
                        .description("Glass med avokado, matcha och pistagemandel. Snabb att fixa och äts direkt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/688DR0xyGHcgPAAGu86jJl/0359865a97d855cf98d482fc6390f398/Snabb_avocadoglass_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Avokadoglass med matcha").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/lammstek-med-rosmarin-fullkornsbulgursallad")
                        .cookingTime(60)
                        .description("Lamm är den perfekta påskmaten. Här med lätta tillbehör med mycket grönt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2Ehz41h05IwWrHuNuRsTqC/126327513c96ae6f11e161aa40af6151/Recept_-_Lammstek_kryddad_med_rosmarin_serverad_med_fullkornsbulgursallad_med_mycket_f__rg_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Lammstek kryddad med rosmarin ").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/saffransmuffins-med-apple-russin-och-mandel")
                        .cookingTime(30)
                        .description(
                                "Saffransmuffins är ett lättbakat alternativ till lussekatter om du inte hinner med att baka det.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2YcvhWU5L12QXlIP2NsPrM/541863c1e0434a89e3c090e15c0ce29c/Saffransmuffins_med___pple_russin_och_mandel_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Saffransmuffins ").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/bonburgare-med-pico-di-gallo-avokado-och-agg")
                        .cookingTime(45)
                        .description(
                                "De här bönburgarna är godare än traditionella med kött. Mycket smak och kladd. Precis som en burgare ska vara.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/64uRSi7tngIuMBeRxc1kap/980290bd4663e040988e29110275a045/Recept_-_B__nburgare_med_pico_di_gallo__avokado_och___gg_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Bönburgare med pico di gallo").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/vafflor-med-karamelliserade-bananer-valnotter-och-matyoghurt")
                        .cookingTime(35)
                        .description(
                                "Våfflor med karamelliserade bananer, valnötter och matyoghurt. Servera som lyxig frukost eller mellanmål för barnen.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1XNGjqvFEnj0NBK67C3g4H/c19cece9b081430f38d28a6cf3b55934/vafflor-med-karamelliserade-bananer-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Våfflor med karamelliserade bananer").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/vaffelmackor-med-pesto-spenat-och-mozzarella")
                        .cookingTime(10)
                        .description(
                                "Macka med pesto och mozzarella som du kan göra i våffeljärnet. Perfekt snabbmat när det är bråttom.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2cDuPeY8CNbfaxkJKl3YsN/476edfbe1d3835a6e071a658121dd936/V__ffelmacka_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Våffelmackor med pesto och mozzarella").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/kycklingburgare-deluxe-med-avokado-picklad-rodlok")
                        .cookingTime(45)
                        .description(
                                "Saftiga burgare med mycket smak, gjorda på kycklingfärs. Serveras med avokado, picklad rödlök och currymajonnäs.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4xXpNMo7kwtpmK1ywoh22O/4dab1ebda90b5d10b76062398544d44d/Recept_-_Kycklingburgare_deluxe_med_avokado__picklad_r__dl__k_och_currymajonn__s_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kycklingburgare deluxe ").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/senapsgriljerad-kalkonstek-med-rostad-brysselkal-med-apelsinvinagrett")
                        .cookingTime(90)
                        .description(
                                "Prova kalkonstek i jul. Saftigt och gott kött. Varm rödkålssallad passar också bra till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6Ukjzt1ejXTy1i0nsoBegH/f02d3d173d3df68628a5a44193b418fe/Recept_-_Senapsgriljerad_kalkonstek_med_rostad_brysselk__l_med_apelsinvin__grett_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Senapsgriljerad kalkonstek").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/apelsingriljerad-kalkonstek-gronkal")
                        .cookingTime(105)
                        .description(
                                "Apelsingriljerad kalkonstek är ett alternativ till traditionell julskinka. Serveras med krämig grönkål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/DYMra8KVfrdH6HsohrgAA/e449cb4df7dfb7bfe66085d0c8cb5f58/Apelsingriljerad_kalkonstek_med_kr__mig_gr__nk__l_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Apelsingriljerad kalkonstek ").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/snabb-lunchomelett-med-avokado-feta-och-rucola")
                        .cookingTime(15).description("Den här omeletten gör succé på brunchen eller lunchen!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4UQrzBx7IVZ9yhLLMagejV/f546bf470333206825b1fae9eef78d9b/Recept_-_Snabb_lunchomelett_med_avokado__feta_och_rucola_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Omelett med avokado, feta och rucola").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/hostsallad-med-makrill-rodbetor-och-apple")
                        .cookingTime(60)
                        .description(
                                "Ta tillvara på rotfrukterna nu i höst. Här kommer en fin lunchsallad eller lättare kvällsrätt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4R3MBssf91JIPQ6TkYhY4N/e00e8c0b4a6163f9fa9aca8f90d2ab7a/Recept_-_Sensommarsallad_med_makrill__r__dbetor_och___pple_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Sallad med makrill, rödbetor och äpple").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/fattiga-riddare-med-stekta-applen-kanel-och-honung")
                        .cookingTime(15)
                        .description(
                                "Gott att göra av överblivet bröd. Passar både som frukost, mellanmål eller kvällsfika.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6VFSDpDbfeHLcqKKdFuix4/9312abb3fc8144dcebeadde55643b1ef/Recept_-_Fattiga_riddare_med_stekta___pplen__kanel_och_honung_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Fattiga riddare med stekta äpplen").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kikartsgryta-med-ris")
                        .cookingTime(30)
                        .description(
                                "Gryta med kikärtor är en enkel vardagsmiddag. Den här grytan serveras med ris och avokado-salladslökstopping.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/PMPDYhJHu0LLDrVHqKeIb/8c9b4661f4ec6c9e514eb691868f5549/Kik__rtsgryta_med_ris_och_avokado-salladsl__kstopping_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Kikärtsgryta med ris ").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/sharonfrukt-med-kardemummayoghurt-och-lime")
                        .cookingTime(10)
                        .description(
                                "Sharonfrukt passar bra som dessert med lite turkisk yoghurt eller som mellanmål med Keso, vanlig yoghurt eller lättyoghurt. Eller varför inte som frukost?")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3fzBANooO4BHuXko0yVAdA/028667741d86fc98eab76c419adc6db8/Sharonfrukt-med-kardemummayoghurt-och-lime-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Sharonfrukt med yoghurt och lime").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/grillad-cosmopolitansallat-med-salsa-och-grillat-kott")
                        .cookingTime(45).description("Sallad är gott att grilla. Satsa på grillade grönsaker.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4S7zWaBhz2X4MumtZgrrMw/5ad37716bfbbddc536212d768164c40d/Grillad_cosmopolitansallad_med_salsa_och_grillat_kott_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Grillad cosmopolitansallat, kött och salsa").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/foliepaket-pa-grillen-med-sotpotatis-lax")
                        .cookingTime(40)
                        .description("Hela middagen i ett paket. Enkel och god allt-i-ett-rätt med lax och sötpotatis.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5q48ZXTnBNsMagfopL8NIM/5149d9368011b4fd5ee82bd53f575269/Foliepaket_p___grillen_med_s__tpotatis_och_lax_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Foliepaket med sötpotatis och lax").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/appelkaka-med-citron-pinjenotter")
                        .cookingTime(75).description("Baka äppelkaka med citron, pinjenötter och russin.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/cQBryFB655UETbHsJqjJs/5c1b32c496e2d4bd8df213a336cbfa03/__ppelkaka_med_citron__pinjen__tter_och_russin._Desktop_.png?w=820&h=820&q=90&fm=png")
                        .title(" Äppelkaka med citron, pinjenötter, russin").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/fisksopp-gryta-med-skaldjur-och-rotfrukter")
                        .cookingTime(50)
                        .description(
                                "Skaldjur och fisk tillsammans med potatis är gott och mättande. Passar utmärkt till lite festligare tillfällen.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/796ps4pFFiojsogePweY2h/3e5b4dbb9f14cf792dd7811f11503b8c/Recept_-_Fisksopp-gryta_med_skaldjur_och_rotfrukter_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Fisksoppa med skaldjur och rotfrukter").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/soppa-av-gronkal-broccoli-sojabonor")
                        .cookingTime(35)
                        .description("Soppa med grönkål, broccoli och sojabönor som ger både protein och mättnad.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3XijlGPvZsDn5fE2XWM52B/fbd2209e8c57bc35c5b1f0815481c5ea/Supersoppa_av_gr__nk__l__broccoli_och_sojab__nor_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Soppa av grönkål, broccoli och bönor ").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/saffransbutterkaka-med-kanel-russin")
                        .cookingTime(60)
                        .description(
                                "Kanel och saffran går utmärkt ihop. I den här fina butterkakan samsas smakerna med blonda russin.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2BR9q1HEjmT3Oe2lnETMeq/31017a9436df201422216156b23173e6/Kallj__st_saffransbutterkaka_med_kanel_och_russin_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Saffransbutterkaka med kanel och russin ").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/macka-med-kalkon-och-appel-pepparrotskesella")
                        .cookingTime(10)
                        .description(
                                "En riktig matig macka du kan äta som mellanmål eller lunch. Kalkonen kan bytas ut mot rökt lax.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2TZ9eHeK8r5Ym7EQVvnlXv/f85fb36888de9f3c013e1b111402d3b3/Macka_med_kalkon_och___ppel-pepparrotskesella_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Kalkonmacka med äppel-pepparrotskräm").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/blodapelsin-med-keso-citronnotter")
                        .cookingTime(15)
                        .description(
                                "Blodapelsin med keso och citronnötter- och frön, perfekt som mellanmål eller lyxig frukost.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/13fIS26CGNqdp5NpDRc2IT/94513da4188fbc2c834f12599d4df4ed/Blodapelsin_med_keso_och_citronn__tter-_och_fr__n_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Blodapelsin med keso och nötter- och frön").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/rostad-grotblandning")
                        .cookingTime(20)
                        .description(
                                "Gröten blir så mycket godare med blandade gryn som dessutom är rostade. Det här är ju som en müsli, så om du vill kan du äta den okokt. Bara att strö på filen eller yoghurten.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1CUCer3tFdeRZvuoDjFVnj/cc8e150dcd9989050c6667eaea098438/Recept_-_Rostad_gr__tblandning_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Rostad grötblandning").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/risgrot-pa-fullkornsris-med-appelkompott")
                        .cookingTime(100)
                        .description("Risgröten får mustigare smak och blir mer mättande med fullkornsris.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/165nbG1djFW2pQ4tzXglNR/fb92207863de6903d6617f65d9108009/Recept_-_Risgr__t_p___fullkornsris_med___ppelkompott_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Risgröt på fullkornsris med äppelkompott").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/fyrkrossgrot-med-dadlar-och-kanel")
                        .cookingTime(40)
                        .description(
                                "Gröt på de krossade kornen av de fyra sädesslagen gör dig mätt och belåten hela förmiddagen. Smaksätt med dadlar och kanel.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6PtLuw2aWPhmcfhBWdDlVE/5484b186475dd51d00da4297d8773fb5/Recept_-_Fyrkrossgr__t_med_dadlar_och_kanel_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Fyrkrossgröt med dadlar och kanel").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/gron-scramble").cookingTime(20)
                        .description(" Ta vad du har i kylen och sväng ihop en snabblagad ”scramble”, alltså äggröra.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1GBJofiQusp9f4vozAt7uB/fd0de797cfcdd3bf14bc2cc25e3141f8/Recept_-_Gr__n____scramble____-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Grön ”scramble”").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/sunda-recept/french-toast-med-jordgubbar")
                        .cookingTime(15)
                        .description(
                                "En lyxig frukost eller matig fika är den här goda ”french toasten” med rårörda jordgubbar. Lyxig smörgås med sötma!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4m15aS4dT5ylM1iUHFRcmJ/9e873c8dddb4665cd988ad8d312dc12a/Recept_-_French_toast_med_jordgubbar_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("French toast med jordgubbar").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/grahamsvafflor-med-mango-hallonglass")
                        .cookingTime(35)
                        .description(
                                "Våfflor med grahamsmjöl ger en mustigare smak. Passar bra både som fika, frukost och mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3CL8N7eAMSKC54toWHrf9L/49887e1922ae65614d328a3a6371b523/Recept_-_Grahamsv__fflor_med_mango-hallonglass_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Grahamsvåfflor med mango-hallonglass").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/frukostkakor").cookingTime(45)
                        .description("Enkla kakor perfekta till snabbfrukosten eller som mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5zTbDlekUPnjnl5x2Aa0Pq/c19af8ace38b18c026ff096845455005/Recept_-_Frukostkakor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Frukostkakor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/dinkelvafflor-med-keso-och-bar")
                        .cookingTime(40)
                        .description(
                                "Härliga våfflor med lite fullkorn som passar utmärkt till frukost eller efter soppa.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/NZ7YCh5n3EG827rOFTkwy/909ee326832e21d90f2cebe708e52d18/Recept_-_Dinkelv__fflor_med_keso_och_b__r_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Dinkelvåfflor med keso och bär").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/bovetegrot-med-bakad-frukt")
                        .cookingTime(35)
                        .description(
                                "Bovete är en ört och passar den som inte tål gluten. Flingorna går fort att koka och det är ett alternativ till den vanliga havregrynsgröten.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/Z9CBr1H3dpcWBxkEx9SEf/bf514de857ead7b9bfddc6efe9a6521e/Recept_-_Bovetegr__t_med_bakad_frukt_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Bovetegröt med bakad frukt").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/aggsallad-till-knackebrod")
                        .cookingTime(10).description("Perfekt stadigt mellanmål eller frukost.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/462v04AgWk6I3TxhBeonFd/cd867f5034bde4e65cbf1e8ab0e9fc77/Recept_-___ggsallad_till_kn__ckebr__d_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Äggsallad till knäckebröd").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/smoothiebowl-med-lingon-banan-och-kardemumma")
                        .cookingTime(10)
                        .description(
                                "Att äta smoothie ur skål är smart för då kan man toppa med goda och hälsosamma toppingar.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4q3owuf8LncXKa38m0aknF/5c684841b1042a10cc0d5052a8225d3f/Recept_-_Smoothiebowl_med_lingon__banan_och_kardemumma_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Smoothiebowl med lingon, banan och kardemumma").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/keso-och-skorpor-med-apple-kanel")
                        .cookingTime(5)
                        .description(
                                "Keso och skorpor med äpple och kanel är enkelt och bra som mellanmål eller frukost.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6ceL8oNhujFfTcq0Z3WmPL/5da95f8b068714db96b4941bf392786c/Recept_-_Keso_och_skorpor_med___pple_och_kanel_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Keso och skorpor med äpple och kanel").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/hemgjord-nyponsoppa").cookingTime(10)
                        .description("Gör hemgjord nyponsoppa och ät som uppfriskande mellanmål eller till frukost.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5jDHDJWe8FpsLdeS5qRVeG/e3ea531e4f28c827f985faab1b30773a/Recept_-_Hemgjord_nyponsoppa_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Hemgjord nyponsoppa").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/havresmoothie").cookingTime(10)
                        .description(
                                "Smoothie med havregryn ger en längre mättnadskänsla. Gott till frukost och mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2s9xtGHeR3mQRYMdTKnLty/28dec15f86c87536036fe61efd9b30c9/Recept_-_Havresmoothie_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Havresmoothie").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/havrescones-med-snabbrorda-bar")
                        .cookingTime(30).description("Havrescones är goda till te, som mellanmål, frukost eller fika.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7LI3ptHJFkC3eV48oSxNam/c0e384b07a9b20de2dd0487fe85ef005/Recept_-_Havrescones_med_snabbr__rda_b__r_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Havrescones med snabbrörda bär").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/havrepannkakor").cookingTime(20)
                        .description("Mustiga pannkakor med havre blir en  härlig frukost eller matigt mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2RXo9HiRydaiXjz6AZDtq/8052dc2ad06c4873aa244f79066241c4/Recept_-_Havrepannkakor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Havrepannkakor").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/grotplattar-av-havregrynsgrot-med-rarorda-frysta-bar-och-keso")
                        .cookingTime(20)
                        .description(
                                "Grötplättar av havregrynsgröt med rårörda frysta bär. God helgfrukost eller mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5HuJsRVcCkzkzCBFGsb14H/4be42e725e53724fdcb08e39b62794ba/Recept_-_Gr__tpl__ttar_av_havregrynsgr__t_med_r__r__rda_frysta_b__r_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Grötplättar ").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/gron-smoothie").cookingTime(5)
                        .description(
                                "En smoothie som kryllar av vitaminer och mineraler, med härligt krämig konsistens och fantastisk smak!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6PzapP7XABRSYQR1svDlCt/a90911bc25024e96a7681af488e5e6e8/Recept_-_Gr__n_smoothie_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Grön smoothie").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/appelpannkakor").cookingTime(25)
                        .description("Underbara frukostpannkakor med äpple. Servera gärna keso till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1zyVPa61zFjQFSyu5uWhU3/65d114790269bd3cc96819cf56d7af3b/appelpannkakor_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Äppelpannkakor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/bananpannkakor-med-blabar")
                        .cookingTime(10)
                        .description(
                                "Enkla bananpannkakor som passar utmärkt till frukost, brunch eller mellanmål. Gott med blåbär eller andra bär till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3JJg4sMyQ4X28jailE8Trp/81552da7c5e24b090daf464c3c45a286/Bananpannkakor_med_bl__b__r_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Bananpannkakor med blåbär").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/grot-med-banan-jordnotssmor")
                        .cookingTime(5)
                        .description(
                                "Mättande gröt med banan och jordnötssmör som även kan ätas som lättlunch. Gott och hälsosamt att blanda upp de klassiska havregrynen med råggryn.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6RoMjRhJNpZCim2pPzlVja/05f1cab24df93ad5e54e195681cb30db/Gr__t_med_banan_och_jordn__tssm__r_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Gröt med banan och jordnötssmör").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/blabarssoppa").cookingTime(10)
                        .description(
                                "Perfekt mellanmål med keso eller som frukost. Enkelt att göra på både färska och frysta blåbär.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3ZjFPVtppZGXtuajrUkux2/efca7a60a50c297a27f3958506ba2e2c/Bl__b__rssoppa_dekstop.png?w=820&h=820&q=90&fm=png")
                        .title("Blåbärssoppa").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/snabbt-mellanmal-med-fil-och-knacke")
                        .cookingTime(3).description("Snabbt och enkelt mellanmål med rårörda lingon och äppelmos.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5Y2ZzFLONv5sDbPEstOuRx/3eacb654bde3036d6faff9320ba2ff54/Snabbt_mellanm__l_med_fil_och_kn__cke_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Snabbt mellanmål med fil och knäcke").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/quinoa-frutti").cookingTime(20)
                        .description("En bra frukost eller mellanmål med quinoa som du förbereder på kvällen.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7EQVoz0Kw2bKrAs8jTSXsn/ee671a90411a9dd34fcdf3941699055e/Quinoa-frutti-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Quinoa-frutti").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/lunchmacka-med-avokado-och-kalkon")
                        .cookingTime(10)
                        .description(
                                "Mättande och god macka med avokado och kalkon. Passar både till frukost, lunch eller att ta med på utflykten.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6IaqNIRq6Xyvx4gnhYr3XJ/c27faae80ee6a036ce5ea2c8d96695c9/lunchmacka-avokado-kalkon_820x820.png?w=820&h=820&q=90&fm=png")
                        .title("Lunchmacka med avokado och kalkon").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/ragfrukostbrod").cookingTime(110)
                        .description("Baka enkla frukostfrallor med råg och bjud på lyxig helgfrukost.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2CXCnKCHYAWmdBpi66Ix5H/31668a84c7abd6aaafbe60074f5df684/R__gfrukostbr__d_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Rågfrukostbröd").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/rodbetsgrot").cookingTime(10)
                        .description(
                                "Att blanda rödbeta i gröten ger den en vacker röd färg. Med matchande mörka bär får du en riktig antioxidantkick.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6gF4uUFDdeL89LuWx2L5aw/b3d70bc543f5a62b4adc12610582d476/R__dbetsgr__t_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Rödbetsgröt").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/rag-och-linfrogrot-med-apple-och-lingonsalsa")
                        .cookingTime(15)
                        .description(
                                "Gröt är en perfekt start på en aktiv dag. Detta recept innehåller rågflingor och linfrö.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1S4ZZRsKv12J3U5799CEER/a2efaeb5a9d7f1526c2a76952230e65e/R__g-_och_linfr__gr__t_med___pple-_och_lingonsalsa_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Råg- och linfrögröt med äpple- och lingonsalsa").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/aggsallad-med-spenat")
                        .cookingTime(15)
                        .description("Äggsallad med spenat som du kan servera på knäckebröd eller i en avokadohalva.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/2XsYivvW2mudUbcQoxrRFk/c9a2cdcaabd2f0bbfd12aa743d65978c/__ggsallad_med_spenat_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Äggsallad med spenat").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/pannstekt-granola").cookingTime(10)
                        .description("Hemmagjord granola  som gott mellanmål eller som snabbfixad men lyxig frukost. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/60d73PEriCrtKCT2TFelrv/2634d310345a0636f3d045795283eff3/Pannstekt_granola_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Pannstekt granola").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/pannkakor-med-jordgubbskompott-och-keso")
                        .cookingTime(90)
                        .description("Pannkakor med jordgubbar som lyxig frukost, som matigt mellanmål eller fika.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1enRzmX0t4q2iFrBnhRcWQ/10633a91eb8c8e9953189438193e418b/Pannkakor_med_jordgubbskompott_och_keso_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Pannkakor med jordgubbskompott och keso").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/overnight-rye").cookingTime(10)
                        .description(
                                "En twist på den populära frukost- eller mellanmålsrätten \"Overnight oats\" där vi använder rågflingor istället.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/THvCIxUFQq4BeEzx3t9Y4/4c2d010db38ab58f56bf07200f5d5804/Overnight_rye_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Overnight rye").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/potatis-art-sparrissallad-med-ugnsstekt-valborgslax")
                        .cookingTime(60)
                        .description(
                                "Härlig vårsallad som är enkel att göra. Passar till påsk, valborgsafton och andra vår- och försommarfestligheter.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/67WV1h55AoefV0hUZ6ASbb/c02a9a5fe1f01dcc8ed7a99a6277fe17/Recept_-_Potatis-__rt-sparrissallad_med_ugnsstekt_lax_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Vårig potatissallad och lax ").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/raksallad-med-kramig-vitloksdressing")
                        .cookingTime(25).description("Supergod och mättande räksallad med vitlöksdressing.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/noSEH7CE7biN4yNTnxOVB/920b008e043efa8bc573cce0c99bfc9e/Recept_-_R__ksallad_med_kr__mig_vitl__ksdressing_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Räksallad med krämig vitlöksdressing").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/pastasallad-med-kalkonfalu")
                        .cookingTime(30)
                        .description(
                                "Prova kalkonkorv med en härlig pastasallad med mycket grönt i. Hela familjen jublar!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5Pugii3GfuhBb4x1XkG1LE/ed15e2e660f557bc12bda6a7b8b55ef6/Recept_-_Pastasallad_med_kalkonfalu_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Pastasallad med kalkonfalu").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/pasta-puttanesca").cookingTime(15)
                        .description("Enklaste och godaste pastan. Perfekt en fredagskväll med en härlig sallad till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7afGiYwVMsksv8IWHEn4hT/1767f5d1ee162981212cd706eacefa40/Recept_-_Pasta_puttanesca_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Pasta puttanesca").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/not-och-senapspanerad-kycklingfile-med-rostad-farskpotatis")
                        .cookingTime(90)
                        .description(
                                "Nötter är gott att toppa kyckling och fisk med. Prova en härlig grönsakskräm till.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6vfgtCdrQLV4ASGyprnRHx/5ebc140a35071c810b512720f8966714/Recept_-_N__t-_och_senapspanerad_kycklingfil___med_rostad_f__rskpotatis_och_kr__m_p___grillad_aubergine_och_paprika_-_Deskto.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Nöt- och senapspanerad kycklingfilé").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/nyarsoxfile-med-krispig-potatis-rodvinssas")
                        .cookingTime(90)
                        .description(
                                "Klassisk nyårsmat där det gröna fått större plats. Om du har varmluftsugn kan du köra potatis och tomater samtidigt på två olika våningar i ugnen.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7DvX4j8CDHgLQ9cNx5qMjV/5630d40ebd41c41bc6b3e90fbfa55f7b/Recept_-_Ny__rsoxfil___med_krispig_potatis__r__dvinss__s__fylld_tomat_och_vitl__kstekta_gr__na_b__nor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Nyårsoxfilé med krispig potatis").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/ljummen-spenatsallad-med-vita-bonor-och-musslor")
                        .cookingTime(20)
                        .description(
                                "God och snabblagad ljummen sallad. Servera gärna med gott bröd, till exempel vitlöksbröd.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1G2z54TwJWG07v04SGXkyo/0d8ca9e812c26588566e72b70232a2e4/Recept_-_Ljummen_spenatsallad_med_vita_b__nor_och_musslor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Ljummen spenatsallad med vita bönor och musslor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/bibimbap").cookingTime(50)
                        .description(
                                "Bibimbap är Koreas svar på vår pyttipanna. Den här varianten är med strimlad kycklingfilé.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/37QfSRfV5q3Ws2eSJkwSBZ/c752d3c64901db7f7c4109775233daa7/Recept_-_Bibimbap_____koriansk_pytt_i_panna_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Bibimbap - koriansk pytt i panna").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/lammytterfile-med-rostade-jordartsskockor-balsamicosky-och-vitloksstekta-grona-bonor")
                        .cookingTime(60)
                        .description(
                                "Härlig nyårsmat! Du kan blanda jordärtsskockorna med potatis om du vill. Lammytterfilé är perfekt bjudmat med sin milda smak.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/41hO2jLacqQRsivtiD9JY9/a43c578e6559b8b7cffb639db971a25c/Recept_-_Lammytterfil___med_rostade_jord__rtsskockor__balsamicosky_och_vitl__ksstekta_gr__na_b__nor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Lammytterfilé med rostade jordärtsskockor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kycklingkottbullar-i-vita-bonor")
                        .cookingTime(90)
                        .description(
                                "Underbar familjerätt som man står sig på länge. Här är köttfärsen utbytt till kycklingfärs.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1CQXO00fvkJqN1PH97jnMo/03cbae1924e86605671102435d5bb7cd/Recept_-_Kycklingk__ttbullar_i_vita_b__nor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kycklingköttbullar i vita bönor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/ingefarslax-med-pumpapure")
                        .cookingTime(120).description("En laxrätt som är härlig helgmat, lättlagad, god och hälsosam.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1vklFpa6XtYEiceiUj23Xg/2d7c56f65f9a109a888a26e4bc5ecffa/Recept_-_Ingef__rslax_med_pumpapur___-_Mobil.jpg?w=1080&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Ingefärslax med pumpapuré").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/kokt-kolja-med-rak-och-agghack-samt-varm-spenatsallad")
                        .cookingTime(25)
                        .description("Kokt kolja med räk- och ägghack samt varm spenatsallad. Jättegott!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1DubVJ2ZUXMVE5ywgKCdja/36da20dbefaa93e50adbbbd6372c0588/Recept_-_Kokt_kolja_med_r__k-_och___gghack_samt_varm_spenatsallad_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kokt kolja").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/majssoppa").cookingTime(25)
                        .description(
                                "Len och härlig majssoppa som kan inleda en middag eller serveras som lättare rätt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7gZEdjELRvRTCvabeiFvkn/1bfaa8243b49b341990eb18bdf1b1060/Recept_-_Majssoppa_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Majssoppa").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/kottfarsbiffar-med-feta-oliver-potatisstomp")
                        .cookingTime(50)
                        .description(
                                "De flesta gillar köttfärsbiffar. Klassisk husmanskost som är gott och enkelt att göra. De här har en twist av Medelhav.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5gKJEoc6VwX6suiPeR0fct/297f0da7f505c2a9822d0ab641db52a4/Recept_-_K__ttf__rsbiffar_fyllda_med_feta_och_oliver_med_potatisstomp_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Köttfärsbiffar fyllda med feta och oliver med potatisstomp").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/nudelsoppa-med-agg").cookingTime(30)
                        .description("Nudelsoppa med svamp och grönsaker i en ingefärsbuljong med äggklyftor.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3musH7Tc1N0ogqVmRkrkUr/445f8725f9ff4699ec7f9b378de449a1/Nudelsoppa_med___gg_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Nudelsoppa med ägg").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/apelsin-och-linssallad-kyckling")
                        .cookingTime(40).description("En sallad med kyckling och linser att bli mätt på.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/eefeBKpdmMg5684whVGBw/9f093c7584bfbf3127638f1eefa63a15/Apelsin-_och_linssallad_med_kyckling_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Apelsin- och linssallad med kyckling").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/japansk-kalpannkaka-okonomiyaki")
                        .cookingTime(45)
                        .description(
                                "Okonomiyaki är en underbar ”pannkaks-omelett” fullspäckad med nyttig kål och morötter och toppad med ännu mer grönsaker.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7CeU5JvO7gjYaU47Tde2gD/b7206d98e7fb6cf0d683b117b0c4b045/Japansk_k__lpannkaka_____okonomiyaki_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Japansk kålpannkaka - okonomiyaki").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/fyllda-paprikor").cookingTime(60)
                        .description(
                                "Härlig allt-i-ett-rätt som kan varieras med olika slags färs, till exempel kyckling, mager nötfärs eller vegetabiliskt alternativ.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4RSdjP4oeOZooWCfEe8wWW/bf15574e679b80e4733889a24db28c3f/Fyllda_paprikor_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Fyllda paprikor").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/sjomansbiff").cookingTime(90)
                        .description(
                                "Sjömansbiff är en klassisk, god och lättlagad rätt som sköter sig själv i grytan. Riktig husmanskost som serveras med rårörda lingon och grönsaker.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/79nQwilGc2spJ52zp3HTbF/59014b664e20c29fa4d40f1d4bbfee84/Klassisk_sj__mansbiff_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Klassisk sjömansbiff").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/bondomelett-med-potatis-spenat")
                        .cookingTime(45)
                        .description(
                                "Bondomelett med potatis och spenat kan serveras som den är med bröd eller med till exempel lite rökt lax. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/73L2qhJmyNuhDLrepq1wtj/445d46ef2ede2e5acd64c4df4414685f/Bondomelett_med_potatis_och_spenat_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Bondomelett med potatis och spenat").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/senapsmarinerade-rotfrukter-med-puylinser")
                        .cookingTime(50)
                        .description(
                                "Ljummen sallad som passar bra med linser och kanske en liten bit kött, fisk eller fågel.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3bmWP617xFyGWDwxisK1lh/b646725bba563e9b5e09c085b51504a7/Senapsmarinerade_rotfrukter_med_puylinser_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Senapsmarinerade rotfrukter med puylinser").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/vintersallad").cookingTime(25)
                        .description("Det är gott med sallad även på vintern. Frossa i kål, citrus och rotfrukter.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6GfkGL7oZannBe0LDa8twe/60d3040fb19f701d2818234d4b9df3c3/Vintersallad_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Vintersallad").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/torsk-med-agg-och-kaviarrora")
                        .cookingTime(25)
                        .description(
                                "Stekt torsk med en röra av hackat ägg, kaviar och salladslök är en perfekt vardagsmiddag.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/35eTeuJJQT8scC9oWDaJLj/8c35205471f88f17e0d0d96b6f90df9f/Torsk_med___gg-_och_kaviarr__ra_dekstop.png?w=820&h=820&q=90&fm=png")
                        .title("Torsk med ägg- och kaviarröra").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/fisk-i-paket").cookingTime(45)
                        .description("Fisk i paket är en enkel allt-i-ett-rätt med fisk.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/JqR6srOnrUCbUrEqCiSgK/49845c189428936b1639d861730272c7/Fisk_i_paket_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Fisk i paket").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/risonisallad-med-flaskfilerullader")
                        .cookingTime(70)
                        .description(
                                "Risoni är minipasta som ser ut som ris. Perfekt i sallader. Här serverat med saftiga fläskfilérullader.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3aygQodkuDziOUychljotC/0a84c364cc771805bf5a0928e4f6f73d/Risonisallad_med_fl__skfil__rullader_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Risonisallad med fläskfilérullader").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/bonsallad-med-varm-fetaost")
                        .cookingTime(45)
                        .description(
                                "Bönsallad med fetaost och bladpersilja som passar både som tillbehör och vegetarisk middag.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3isenapkGNFNR2RtC5vcmf/442fe8eccb6dec2e29a7498747465b9e/B__nsallad_med_varm_fetaost_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Bönsallad med varm fetaost").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/torsk-i-ugn-med-purjo-och-spenat")
                        .cookingTime(45)
                        .description(
                                "Lär dig flera goda fiskrätter att variera mellan. Här är ett! Torsk i ugn med täcke av purjo och spenat. Enkelt och gott!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5T2iOBLwrr1X8ucllfINYT/6de4a5b65ac9c6844a5db741809d49ed/Torsk_i_ugn_med_t__cke_av_purjo_och_spenat_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Torsk i ugn med täcke av purjo och spenat").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/stekt-roding-kantareller-apple-och-potatisstomp")
                        .cookingTime(40)
                        .description(
                                "Tidig höst är det säsong för röding, så passa på att göra denna goda rätt då; stekt röding med kantareller, stekt äpple och potatisstomp. En festmåltid!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/BPQK7nI4mBFmTFeToOs19/c960c877bf65e58112013b7d29622f0b/Stekt_r__ding_med_kantareller__stekt___pple_och_potatisstomp_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Stekt röding med kantareller").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/svamp-och-potatisbullar-kalsallad-med-lingon")
                        .cookingTime(60)
                        .description(
                                "Recept på svamp- och potatisbullar samt kålsallad med lingon, god mat som är enkel att laga.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1oKPYbQevvkwajDk2tbpgL/9fec2abea9b5cea8257362646efa5b15/Svamp-_och_potatisbullar_samt_k__lsallad_med_lingon_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Svamp- och potatisbullar").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/hemgjorda-fiskpinnar-med-bostondressing")
                        .cookingTime(60)
                        .description(
                                "n fiskrätt som passar hela familjen. Välj rotsaker och kål i olika färger så blir det roligare att servera.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/33EINmD39oStSMG9xqFolS/59c391bd05f7daf892a46844fca06981/fiskpinnar-820x820.jpg?w=1000&h=1000&fl=progressive&q=90&fm=jpg")
                        .title("Hemgjorda fiskpinnar med bostondressing").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kalkonbiffar").cookingTime(45)
                        .description("Kalkonfärs är toppen till biffar. Det går även bra att använda kycklingfärs.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/ZWSL9nUDI88as59cWKAFo/1dcda8cfc8be33c7537008697a166b7a/Kalkonbiffar_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Kalkonbiffar").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/ugnsbakad-lax-med-asiatiska-smaker")
                        .cookingTime(30)
                        .description("Lax i ugn med asiatiska smaker. Friska smaker av ingefära och koriander.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/OQp7VTt6KhxWvbtxvngjM/437abca06634adabee0ff1251243dea1/ugnsbakad-lax-med-asiatiska-smaker-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Ugnsbakad lax med asiatiska smaker").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/kycklingtacos-med-mango-avokadosalsa")
                        .cookingTime(45)
                        .description(
                                "Friskt och gott med mango-avokadosalsa till tacos med kyckling. Här hittar du receptet!")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6FDD6e8ugD0269HJZDaOS/5be0d5a41046df782c666bad65cc2a4e/Recept_-_Kycklingtacos_med_mango-avokadosalsa_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kycklingtacos med mango-avokadosalsa").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kycklingfrikadeller-i-tomatsas")
                        .cookingTime(60)
                        .description(
                                "Kycklingfrikadeller är lätta att göra och blir mycket saftiga och smakrika i den härliga tomatsåsen.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6GyfN8bCBJtbAb6WIlQRHT/e43f58cce9c58b40cf972e067a58f6fb/Recept_-_Kycklingfrikadeller_i_tomats__s_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kycklingfrikadeller i tomatsås").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/matjessill-med-agg-rodbetor-kavringsmulor")
                        .cookingTime(15)
                        .description("Matjessill är superbra snabbmat som går att variera i det oändliga.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6E2cMqRbjHJJINQyrrQDmG/469f02b9c5b9ffbecbe47ee5231bc766/Recept_-_Matjessill_med___gg__r__dbetor_och_stekta_kavringsmulor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Matjessill med ägg och rödbetor ").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/sotpotatisstrips-grillad-hjartsallat-salsa-verde-och-grillad-utbankad-flaskfile")
                        .cookingTime(60)
                        .description("Perfekt grillmiddag. Satsa på mycket grönt och lägg till lite kött.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/RpkLoap39PYMfjFyFBqIV/9f81b6caf82512ca4616ad5b37cad7cc/Recept_-_S__tpotatisstrips__grillad_hj__rtsallat__salsa_verde_och_grillad_utbankad_fl__skfil___-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Sötpotatisstrips, grillad hjärtsallat, salsa verde och grillad utbankad fläskfilé")
                        .build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/snabblunch-pa-jobbet").cookingTime(5)
                        .description(
                                "Tips på vad man kan ha med sig för att göra en snabblunch eller mellanmål på jobbet.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7E0IXIpN8LQ7z8a68zHusI/d7a9f6a15f2186cc1af58cf922248457/Recept_-_Snabblunch_p___jobbet_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Snabblunch på jobbet").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/potatispizza-med-rom")
                        .cookingTime(60)
                        .description(
                                "Här tar vi en genväg med färdig pizzadeg men du kan naturligtvis göra din egen. Det här är en supergod och lite lyxig lunch eller lättare kvällsrätt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3YnvOcHmtq9Xi2XHp4ySrF/2ad3a3dbe5dce98b43d9f9340691faac/Recept_-_Potatispizza_med_rom_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Potatispizza med rom").build(),
                Recipe.builder()
                        .URL("https://www.hjart-lungfonden.se/halsa/recept/lunch-i-burk-falafel-hummus-och-sallad")
                        .cookingTime(25)
                        .description(
                                "Perfekt lunchmat till stranden eller till en picknick i sommar. Smart att återanvända gamla burkar. Tänk på att ju vidare burkar desto lättare att äta. Ta gärna med lite grovt bröd och frukt också.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/6m2cQvqs5MGoY77tNmsyOD/58ccd47967ea7c9a71f3afbd9033aa7d/Recept_-_Lunch_i_burk_____falafel__hummus_och_sallad_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Lunch i burk - falafel, hummus och sallad").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/libabrod-med-rodbetshummus-och-kryddrostade-kikartor")
                        .cookingTime(25)
                        .description(
                                "Perfekt lunchmat. Köp gärna brödet i matbutiker med etniskt sortiment. Lavashbröd eller tortillabröd fungerar också utmärkt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7h8FZiLICX73MV6ltMEZFf/41d9cfc366d981be32639f112608a517/Recept_-_Libabr__d_med_r__dbetshummus_och_kryddrostade_kik__rtor_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Libabröd med rödbetshummus").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/artricotta").cookingTime(10)
                        .description("En röra som är perfekt som dipp eller på smörgås med mycket grönt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/67yTJXRaYObpDvEBAqk5aY/56bdecbc9bafcfcefbc0d8bd0d30760e/Recept_-___rtricotta_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Ärtricotta").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/tortilla-spansk-potatisomelett")
                        .cookingTime(60).description("Alla som varit i Spanien känner igen den här goda tapasrätten. ")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/pJH2eI94aKiKhkyiBa6uC/6f939cd4ebbc6f94c78599349dbeb110/Recept_-_Tortilla_____spansk_potatisomelett_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Tortilla - spansk potatisomelett").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/pan-bagna-sydfransk-lunchmacka")
                        .cookingTime(20).description("Härlig lunchmacka med rötterna i Provence.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7Hq0pnN17f44dj4whFpBMG/d2a4a4a52d7f18aafba8e8648a81c181/Recept_-_Pan_bagna_____sydfransk_lunchmacka_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Pan bagna - sydfransk lunchmacka").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/blodapelsinsallad-med-dadlar-notter-kardemummayoghurt")
                        .cookingTime(15)
                        .description(
                                "Blodapelsinsallad som är perfekt som avslutning på en vardagsmiddag men kan också serveras som lite lyxig helgfrukost, brunch eller mellanmål.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3hsMi3OAaN0Nv86Q8fRoQF/90922b3c9249afc7db91da872cabaa5e/Blodapelsinsallad_med_dadlar__n__tter_och_kardemummayoghurt_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Blodapelsin med kardemummayoghurt").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/vaniljrostade-nektariner-och-jordgubbar-med-glass")
                        .cookingTime(30)
                        .description("Efterrätt med frukt som passar till sommarens middagar och fester.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/5s4IMviwGoiVofIb2vOc6n/8e5ba78976d36b3d28b4e6cd84d83927/Vaniljrostade_nektariner_och_jordgubbar_med_glass_desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Vaniljrostade frukter med glass").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/paskgodis").cookingTime(60)
                        .description(
                                "Bjud på fina praliner eller chokladdoppad torkad frukt istället för ett helt påskägg.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/4hg91jZIDQqFlFis8EJNuf/efc54ead5882c3620c8480135a7fa2e0/Recept_-_P__skgodis_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Påskgodis").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/persikor-i-citron").cookingTime(135)
                        .description("Persikor med frisk citronsmak. Fräsch dessert efter en grillmiddag.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/nTHtaGdw7mbyEgG6Qq2my/f0a5f959ece416453081175c90f9500c/Recept_-_Persikor_i_citron_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Persikor i citron").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/frukt-och-barbricka-med-lite-ost")
                        .cookingTime(15)
                        .description(
                                "Perfekt ”helggodis” medan man tittar på en film. Låt frukt och bär ta största platsen på brickan.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1fyObM0VMOXmFwybLaLh3m/e238474077ea36ec073ccb590b76e00c/Recept_-_Frukt-_och_b__rbricka_med_lite_ost_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Frukt- och bärbricka med lite ost").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/vaniljshake-med-dadlar-och-banan")
                        .cookingTime(10)
                        .description(
                                "Den här goda och hälsosamma milkshaken blandar du lätt ihop på ett par minuter. En milkshake som är som en lite hälsosammare dessert.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7sfyU6yHbKaVURZhtbKCTa/4af95f419330c4d340195875148c9090/Vaniljshake-820x820.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Vaniljshake med dadlar och banan").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/limemarinerad-mango-med-glass")
                        .cookingTime(35).description("Limemarinerad mango med glass är en riktigt snabblagad dessert.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/52Yu8QGOPIegk3T6zbs8sQ/96fa8b598ce74f96c9dac6e5ae88b7ef/Recept_-_Limemarinerad_mango_med_glass_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Limemarinerad mango med glass").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/kryddtekokta-paron-och-sharonfrukt")
                        .cookingTime(40)
                        .description(
                                "Exotisk frukt och sharonfrukt passar bra med andra frukter, till exempel päron. Att koka dem i en lag med te och varma kryddor blir en lätt dessert.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/7KZ7KRaLXpHtCLVvdxFrY0/36f48dd76565a7be93528512d77f5e71/Recept_-_Kryddt__kokta_p__ron_och_sharonfrukt_-_Desktop.jpg?w=820&h=820&fl=progressive&q=90&fm=jpg")
                        .title("Kryddtekokta päron och sharonfrukt").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/smulpaj-med-persika").cookingTime(45)
                        .description("Enkel smulpaj som går snabbt att baka. Passar bra när det är säsong för persika.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/3ChdZRG53QhMSayMq8nKvy/34d7a71c026d9493e71e2cd3c7c0da9d/Smulpaj_med_persika_dektop.png?w=820&h=820&q=90&fm=png")
                        .title("Smulpaj med persika").build(),
                Recipe.builder().URL(
                        "https://www.hjart-lungfonden.se/halsa/recept/snabb-mangoglass-med-kokos-limestrossel-samt-hallon")
                        .cookingTime(10)
                        .description("Snabb och lyxig mangoglass som blir som mjukglass. Servera direkt.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/16a9S1OKGHLmtrDvljKTpD/05079091649ea9006dfbb41b303ceb75/Snabb_avocadoglass_Desktop.png?w=820&h=820&q=90&fm=png")
                        .title("Snabb mangoglass").build(),
                Recipe.builder().URL("https://www.hjart-lungfonden.se/halsa/recept/marangtoppad-fruktsallad")
                        .cookingTime(15)
                        .description("Supergod och lättlagad dessert. Du kan använda vilka frukter och bär du vill.")
                        .imageURL(
                                "https://images.ctfassets.net/e8gvzq1fwq00/1VSvqGmJgHVGsQ5Im96WBJ/8a1846d8348f163e7989c18f271f062f/Mar__ngtoppad_fruktsallad_desktop__1_.png?w=820&h=820&q=90&fm=png")
                        .title("Marängtoppad fruktsallad").build()));
    }
}
