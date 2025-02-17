using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Example_Error_Csharp
{
    class CalcTool
    {
        public void calc3(char z1, out char z2)
        {   
            // z2 je hodnoty typ
            if (z1 >= 'A' && z1 <= 'Z')
            {
                z2 = (char)(z1 + ('a' - 'A'));                
            }

            throw new Exception("Chybny vstupni argument.");
        }
    }
}
