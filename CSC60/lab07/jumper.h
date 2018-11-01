typedef char STR16[16 + 1];
typedef struct jumper_t
{
    STR16 userName;
    //A double array of tires that is N_TRIES in lenth
    double attempts[N_ATTEMPTS];
    double best_jump, deviation;
} jumper_t;
