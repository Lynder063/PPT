#pragma once

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdlib.h>

typedef struct
{
	double a, b, c;
	double obvod, obsah;
	bool rovnoramenny, rovnostranny;
} TTrojuhelnik;

// dopøedná deklarace (lze volat funkce definované pod místem volání)
void spocti_trojuhelnik(TTrojuhelnik *t);
bool test_rovnoramenny(TTrojuhelnik t);
bool test_rovnostranny(TTrojuhelnik t);
bool test_trojuhelnik(TTrojuhelnik t);
