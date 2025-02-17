using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Example_Error_Csharp
{
    class CalcMediator
    {
        public void execute()
        {
            char z;

            CalcTool calcTool = new CalcTool();

            try
            {
                calcTool.calc3('A', out z);
                Console.WriteLine("OK");
            }
            catch (Exception e)
            {
                Console.WriteLine("Error{0}:{1}", 2, 
                    "Chybny vstupni argument." /* e.Message */);
            }          
        }
    }
}
