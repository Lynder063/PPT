#include "pch.h"
#include <iostream>
#include "Fce_Obdelnik.h"

void nacti_strany_obdelnika(Obdelnik &ob)
{
	printf("Zadej strany obdelnika:\n");
	scanf("%lf", &ob.a);
	scanf("%lf", &ob.b);
}

void pocitej_obdelnik(Obdelnik &ob, double &o, double &S)
{
	o = 2 * (ob.a + ob.b);
	S = ob.a * ob.b;
}

void tisk_UdajeObdelnika(Obdelnik &ob, double o, double S)
{
	printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", ob.a, ob.b, o, S);
}

// ----
// ----
