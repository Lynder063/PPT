#include "pch.h"
#include "Tool_Obdelnik.h"
#include "Fce_Obdelnik.h"
#include <iostream>  // kvuli printf

void obdelnik()
{
	double a, b, o, S;

	nacti_strany_obdelnika(a, b);
	pocitej_obdelnik(a, b, o, S);
	tisk_UdajeObdelnika(a, b, o, S);
}

void obdelniky()
{

	obdelnik();

	// ---

	printf("\n\n");
	obdelnik();
}


