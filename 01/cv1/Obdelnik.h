#ifndef OBDELNIK_H
#define OBDELNIK_H

class Obdelnik {
public:
    Obdelnik(double sirka, double vyska);
    double obvod() const;
    double plocha() const;

private:
    double sirka;
    double vyska;
};

#endif // OBDELNIK_H
