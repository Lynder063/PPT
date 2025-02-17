#include "pch.h"
#include <iostream>
#include "Fce_Obdelnik.h"

void nacti_strany_obdelnika(double &a, double &b)
{
	printf("Zadej strany obdelnika:\n");
	scanf("%lf", &a);
	scanf("%lf", &b);
}

void pocitej_obdelnik(double a, double b, double &o, double &S)
{
	o = 2 * (a + b);
	S = a * b;
}

void tisk_UdajeObdelnika(double a, double b, double o, double S)
{
	printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", a, b, o, S);
}

// ----
// ----

/*
void obdelnik()
{
	double a, b, o, S;

	nacti_strany_obdelnika(a, b);
	pocitej_obdelnik(a, b, o, S);
	tisk_UdajeObdelnika(a, b, o, S);
}
*/
