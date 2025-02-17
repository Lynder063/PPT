#include "pch.h"
#include "Tool_Obdelnik.h"
#include "Fce_Obdelnik.h"
#include <iostream>

void obdelnik()
{
	Obdelnik obd;
	double o, S;

	nacti_strany_obdelnika(obd);
	pocitej_obdelnik(obd, o, S);
	tisk_UdajeObdelnika(obd, o, S);
}

