#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include "TTrojuhelnik.h"

void nacti_strany_trojuhelnika(TTrojuhelnik* t);
TTrojuhelnik nacti_strany_trojuhelnika_2();
TTrojuhelnik* nacti_strany_trojuhelnika_2uk();

void tisk_trojuhelnik(TTrojuhelnik t, double obvod, double obsah, bool rovnoramenny, bool rovnostranny);
