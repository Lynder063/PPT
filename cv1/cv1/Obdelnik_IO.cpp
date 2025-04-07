#include "Obdelnik_IO.h"
#include <iostream>

void Obdelnik_IO::zadatData() {
    double sirka, vyska;
    std::cout << "Zadejte sirku obdelniku: ";
    std::cin >> sirka;
    std::cout << "Zadejte vysku obdelniku: ";
    std::cin >> vyska;

    Obdelnik obdelnik(sirka, vyska);
    zobrazitVysledky(obdelnik);
}

void Obdelnik_IO::zobrazitVysledky(const Obdelnik& obdelnik) const {
    std::cout << "Obvod obdelniku: " << obdelnik.obvod() << std::endl;
    std::cout << "Plocha obdelniku: " << obdelnik.plocha() << std::endl;
}
