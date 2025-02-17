#include "TTrojuhelnik_IO.h"

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
