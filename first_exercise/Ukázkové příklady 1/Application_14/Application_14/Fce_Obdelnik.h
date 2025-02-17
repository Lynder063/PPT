#pragma once

typedef struct
{
	double a;
	double b;
	double o;
	double S;

} Obdelnik;

void nacti_strany_obdelnika(Obdelnik &ob);

void pocitej_obdelnik(Obdelnik &ob);

void tisk_UdajeObdelnika(Obdelnik &ob);
