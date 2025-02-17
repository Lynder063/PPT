#include "TTrojuhelnik.h"

// definice funkcí

void spocti_trojuhelnik(TTrojuhelnik *t)
{
    double s;
    s = (t->a + t->b + t->c) / 2;
    t->obsah = sqrt(s * (s - t->a) * (s - t->b) * (s - t->c));
    t->obvod = t->a + t->b + t->c;

    t->rovnostranny = t->a == t->b && t->b == t->c && t->c == t->a;
    t->rovnoramenny = !t->rovnostranny && (t->a == t->b || t->b == t->c || t->c == t->a);
}

bool test_rovnoramenny(TTrojuhelnik t)
{
    return !test_rovnostranny(t) && (t.a == t.b || t.b == t.c || t.c == t.a);
}

bool test_rovnostranny(TTrojuhelnik t)
{
    return t.a == t.b && t.b == t.c && t.c == t.a;
}

bool test_trojuhelnik(TTrojuhelnik t)
{
    bool test = t.a > 0.0 && t.b > 0.0 && t.c > 0.0;
    test = test && ((t.a + t.b) > t.c && (t.b + t.c) > t.a && (t.c + t.a) > t.b);
    return test;
}

