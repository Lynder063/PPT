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

TTrojuhelnik nacti_strany_trojuhelnika_2()
{
    TTrojuhelnik tr;
    printf("Zadej stranu a: ");
    scanf("%lf", &tr.a);
    printf("Zadej stranu b: ");
    scanf("%lf", &tr.b);
    printf("Zadej stranu c: ");
    scanf("%lf", &tr.c);

    return tr;
}

TTrojuhelnik* nacti_strany_trojuhelnika_2uk()
{
    TTrojuhelnik *uk_tr = (TTrojuhelnik *) malloc(sizeof(TTrojuhelnik));
    printf("Zadej stranu a: ");
    scanf("%lf", &uk_tr->a);
    printf("Zadej stranu b: ");
    scanf("%lf", &uk_tr->b);
    printf("Zadej stranu c: ");
    scanf("%lf", &uk_tr->c);

    return uk_tr;
}

void tisk_trojuhelnik(TTrojuhelnik t, double obvod, double obsah, bool rovnoramenny, bool rovnostranny)
{
    printf("Trojuhelnik:\na = %f\nb = %f\nc = %f\n", t.a, t.b, t.c);
    printf("Obvod = %f\nObsah = %f\n", obvod, obsah);
    printf("Rovnoramenny = ");
    if (rovnoramenny == 0)
        printf("NE");
    else
        printf("ANO");
    printf("\nRovnostranny = ");
    if (rovnostranny == 0)
        printf("NE");
    else
        printf("ANO");
    printf("\n");
}
