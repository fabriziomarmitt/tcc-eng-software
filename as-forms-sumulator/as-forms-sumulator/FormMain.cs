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
        private const int WM_NCHITTEST = 0x84;
        private const int HTCLIENT = 0x1;
        private const int HTCAPTION = 0x2;

        ///
        /// Handling the window messages
        ///
        protected override void WndProc(ref Message message)
        {
            base.WndProc(ref message);

            if (message.Msg == WM_NCHITTEST && (int)message.Result == HTCLIENT)
                message.Result = (IntPtr)HTCAPTION;
        }
        public FormMain()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {           
            var token = "GQDstcKsx0NHjPOuXOYg5MbeJ1XT0uFiwDVvVBrk";        
            ProcessStartInfo sInfo = new ProcessStartInfo(string.Format("http://localhost:9000/login?token={0}", token));
            Process.Start(sInfo);
        }      
    }
}
