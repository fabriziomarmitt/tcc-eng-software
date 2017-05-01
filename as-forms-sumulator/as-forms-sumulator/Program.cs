using as_forms_sumulator.Model;
using JWT;
using JWT.Serializers;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Windows.Forms;

namespace as_forms_sumulator
{    
    static class Program
    {
        internal static Dictionary<string, object> GlobalVariables = new Dictionary<string, object>();
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main(string[] args)
        {
            var secret = "GQDstcKsx0NHjPOuXOYg5MbeJ1XT0uFiwDVvVBrk";
            Uri url = null;
            string token = null;
            Credentials credentials = null;
            if(args.Length > 0) {
                url = new Uri(args[0]);                
                token = HttpUtility.ParseQueryString(url.Query).Get("token");
                if (token != null) { 
                   
                    try
                    {
                        IJsonSerializer serializer = new JsonNetSerializer();
                        IDateTimeProvider provider = new UtcDateTimeProvider();
                        IJwtValidator validator = new JwtValidator(serializer, provider);
                        IBase64UrlEncoder urlEncoder = new JwtBase64UrlEncoder();
                        IJwtDecoder decoder = new JwtDecoder(serializer, validator, urlEncoder);
                        var json = decoder.Decode(token, secret, verify: true);
                        credentials = decoder.DecodeToObject<Credentials>(token, secret, false);
                    }
                    catch (TokenExpiredException)
                    {
                        Console.WriteLine("Token has expired");
                    }
                    catch (SignatureVerificationException)
                    {
                        Console.WriteLine("Token has invalid signature");
                    }
                }
            }

            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            if (credentials != null && credentials.username == "teste" && credentials.password == "teste")
            {
                Application.Run(new FormMain());
            }           
            else
            {
                Application.Run(new FormLogin());
            }
        }
    }
}
