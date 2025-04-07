#ifndef OBDELNIK_IO_H
#define OBDELNIK_IO_H

#include "Obdelnik.h"

class Obdelnik_IO {
public:
    void zadatData();
    void zobrazitVysledky(const Obdelnik& obdelnik) const;
};

#endif // OBDELNIK_IO_H
