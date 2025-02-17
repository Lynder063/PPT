#pragma once

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdlib.h>

typedef struct
{
	double a, b, c;
} TTrojuhelnik;

// dopøedná deklarace (lze volat funkce definované pod místem volání)
double spocti_obvod(TTrojuhelnik t);
double spocti_obsah(TTrojuhelnik t);
bool test_rovnoramenny(TTrojuhelnik t);
bool test_rovnostranny(TTrojuhelnik t);
bool test_trojuhelnik(TTrojuhelnik t);
