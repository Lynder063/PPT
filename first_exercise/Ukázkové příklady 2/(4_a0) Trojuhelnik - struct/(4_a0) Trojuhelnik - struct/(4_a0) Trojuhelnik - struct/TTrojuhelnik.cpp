#include "TTrojuhelnik.h"

// definice funkcí

double spocti_obvod(TTrojuhelnik t)
{
    /*
    double obvod;
    obvod = t.a + t.b + t.c;
    return obvod;
    */
    return t.a + t.b + t.c;
}

double spocti_obsah(TTrojuhelnik t)
{
    double s;
    double obsah;
    s = (t.a + t.b + t.c) / 2;
    obsah = sqrt(s * (s - t.a) * (s - t.b) * (s - t.c));    
    return obsah; 
    // obsah = sqrt((t.a + t.b + t.c) / 2 * ((t.a + t.b + t.c) / 2 - t.a) * ((t.a + t.b + t.c) / 2 - t.b) * ((t.a + t.b + t.c) / 2 - t.c));
    // return sqrt(s * (s - t.a) * (s - t.b) * (s - t.c));
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

/*
void nacti_strany_trojuhelnika(TTrojuhelnik* t)
{
    printf("Zadej stranu a: ");
    scanf("%lf", &t->a);
    printf("Zadej stranu b: ");
    scanf("%lf", &t->b);
    printf("Zadej stranu c: ");
    scanf("%lf", &t->c);
}

void tisk_trojuhelnik(TTrojuhelnik t)
{
    printf("Trojuhelnik:\na = %f\nb = %f\nc = %f\n", t.a, t.b, t.c);
    printf("Obvod = %f\nObsah = %f\n", t.obvod, t.obsah);
    printf("Rovnoramenny = ");
    if (t.rovnoramenny == 0)
        printf("NE");
    else
        printf("ANO");
    printf("\nRovnostranny = ");
    if (t.rovnostranny == 0)
        printf("NE");
    else
        printf("ANO");
    printf("\n");
}
*/
