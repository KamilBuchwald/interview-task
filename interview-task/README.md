# Zadanie rekrutacyjne - autosystem

## Dostępność
W celu przetestowania api można skorzystać z publicznego adresu: http://interview.byst.re/autosystem/
(przykładowe zapytanie o filtr dla Volkswagen Passat: https://interview.byst.re/autosystem/dealer/vehicle-parts/Volkswagen/Passat/Filtr)

Istnieje również możliwość przejrzenia aplikacji zdalnie za pomocą SwaggerUI - niestety z powodu konfiguracji Cloudflare nie ma możliwości zdalnie przetestować 
kodu - w tym celu należy zbudować aplikację lokalnie
https://interview.byst.re/autosystem/swagger-ui/

W repozytorium znajduje się również kolekcja JSON gotowa do zaimportowania do narzędza Postman.


## Przykładowe dane
Aplikacja uruchamia się domyślnie z poniższym zestawem danych.
Data rozpoczęcia serwisu dla danych części jest zawsze datą uruchomienia aplikacji w celu ulatwienia testowania najlepiej
użyć narzędzia online do generowania wartości Timestamp - https://timestampgenerator.com/. Data zakończenia serwisu dla danych części
to zawsze data uruchomienia aplikacji + ilość dni podana w ostatniej kolumnie.



| Marka      | Model  | Nazwa Części                                                         | Opis Części                                                                 | Data zakończenia serwisu dla części |
|------------|--------|----------------------------------------------------------------------|-----------------------------------------------------------------------------|-------------------------------------|
| Volkswagen | Passat | Filtr hydrauliczny automatycznej skrzyni biegów FEBI BILSTEIN 101900 | Rodzaj filtra: Filtr sitowy                                                 | +10 dni                             |
| Volkswagen | Passat | SONDA LAMBDA FEBI BILSTEIN 17536                                     | Długość [mm]: 437                                                           | +15 dni                             |
| BMW        | X5     | SFERA HYDROPNEUMATYCZNA FEBI BILSTEIN 26537                          | Rodzaj filtra: Filtr sitowy                                                 | +6 dni                              |
| BMW        | X5     | Zacisk hamulca FERODO FCL695100                                      | typ zacisku hamulca: Zacisk hamulcowy ze zintegrowanym hamulcem pomocniczym | +12 dni                             |
| Audi       | A4     | Akumulator ciśnienia układu zawieszenia FEBI BILSTEIN 01817          | 4027816018179                                                               | +3 dni                              |
| Audi       | A4     | Klocki hamulcowe FERODO FDB4842                                      | Oznaczenie kontrolne: R90 Homologated                                       | +30 dni                             |
