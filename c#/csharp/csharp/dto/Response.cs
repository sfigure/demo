using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharp.dto
{
    class Response<T>
    {
       public int code;
       public T body;
       public String msg;
    }
}
