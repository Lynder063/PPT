#include "pch.h"
#include "Tool_Obdelnik.h"
#include "Fce_Obdelnik.h"

void obdelnik()
{
	Obdelnik ob;

	nacti_strany_obdelnika(ob);
	pocitej_obdelnik(ob);
	tisk_UdajeObdelnika(ob);
}
