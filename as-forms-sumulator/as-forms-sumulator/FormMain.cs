using System;
using System.Windows.Forms;
using System.Diagnostics;
using System.Security.Cryptography;
using System.Collections.Generic;
using JWT;
using JWT.Algorithms;
using JWT.Serializers;
using as_forms_sumulator.Model;

namespace as_forms_sumulator
{
    public partial class FormMain : Form
    {
        public FormMain()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {           
            var token = "GQDstcKsx0NHjPOuXOYg5MbeJ1XT0uFiwDVvVBrk";            
            ProcessStartInfo sInfo = new ProcessStartInfo(String.Format("http://localhost:8181/sso?token={0}", token));
            Process.Start(sInfo);
        }
    }
}
