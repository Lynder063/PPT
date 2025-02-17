// Application_10.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include "pch.h"

#include "Fce_Obdelnik.h"

void obdelnik()
{
	double a, b, o, S;

	nacti_strany_obdelnika(a, b);
	pocitej_obdelnik(a, b, o, S);
	tisk_UdajeObdelnika(a, b, o, S);
}

int main()
{
	obdelnik();
}
