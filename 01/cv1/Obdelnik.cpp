#include "Obdelnik.h"

Obdelnik::Obdelnik(double sirka, double vyska) : sirka(sirka), vyska(vyska) {}

double Obdelnik::obvod() const {
    return 2 * (sirka + vyska);
}

double Obdelnik::plocha() const {
    return sirka * vyska;
}
