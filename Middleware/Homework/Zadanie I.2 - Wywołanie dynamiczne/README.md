# Zadanie I.2 - Wywołanie dynamiczne

Celem zadania jest demonstracja działania wywołania dynamicznego po stronie klienta middleware. Wywołanie dynamiczne to takie, w którym nie jest wymagana znajomość interfejsu zdalnego obiektu lub usługi w czasie kompilacji, lecz jedynie w czasie wykonania. Wywołania powinny być zrealizowane dla kilku (trzech) różnych operacji/procedur używających przynajmniej w jednym przypadku nietrywialnych struktur danych (np. listy (sekwencji) struktur). Nie trzeba tworzyć żadnego formatu opisującego żądanie użytkownika ani parsera jego żądań - wystarczy zawrzeć to wywołanie "na sztywno" w kodzie źródłowym, co najwyżej z konsoli parametryzując szczegóły danych. Jako bazę można wykorzystać projekt z zajęć. Trzeba przemyśleć i umieć przedyskutować przydatność takiego podejścia w budowie aplikacji rozproszonych
ICE: Dynamic Invocation https://doc.zeroc.com/ice/3.7/client-server-features/dynamic-ice/dynamic-invocation-and-dispatch
gRPC: „dynamic grpc”, “reflection”, grpcurl

Technologia middleware: Ice albo gRPC

Języki programowania: dwa różne (jeden dla klienta, drugi dla serwera)

Maksymalna punktacja: 6

## Wybrane technologie

- gRPC
- Python - klient
- Java - serwer
- grpcurl

## Uruchamianie

### Klient

Z pomocą terminala w katalogu `client` należy użyć `py client 127.0.0.5:50051`.

### Serwer

Najlepiej odpalić go z pomocą programu Intelij. Wszytskie potrzebne do tego pliki pozostały w katalogu server.
