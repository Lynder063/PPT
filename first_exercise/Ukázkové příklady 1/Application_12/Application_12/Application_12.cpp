// Application_12.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include "pch.h"
#include <iostream>

#include "Tool_Obdelnik.h"
#include "Fce_Obdelnik.h"  // kvuli my_task

void my_task()
{
	double a1, b1, a2, b2;
	double o1, S1, o2, S2;

	nacti_strany_obdelnika(a1, b1);
	nacti_strany_obdelnika(a2, b2);

	pocitej_obdelnik(a1, b2, o1, S1);  // !!!
}

int main()
{
	//obdelnik();
	obdelniky();

	// ---

	my_task();
}
