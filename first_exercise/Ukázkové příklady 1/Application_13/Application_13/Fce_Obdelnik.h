#pragma once

typedef struct
{
	double a;
	double b;

} Obdelnik;

void nacti_strany_obdelnika(Obdelnik &ob);

void pocitej_obdelnik(Obdelnik &ob, double &o, double &S);

void tisk_UdajeObdelnika(Obdelnik &ob, double o, double S);
