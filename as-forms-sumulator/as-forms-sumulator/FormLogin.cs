using as_forms_sumulator.Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace as_forms_sumulator
{
    public partial class FormLogin : Form
    {
        public FormLogin()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            if (!(txtUsername.Text == "teste" && txtPassword.Text == "teste")) {
                MessageBox.Show("Nome de usuário ou senha são inválidos");
                return;
            }

            Program.GlobalVariables = Program.GlobalVariables.Where(k => k.Key != "credentials").ToDictionary(entry => entry.Key, entry => entry.Value);
                        
            Program.GlobalVariables.Add("credentials", new Credentials()
            {
                username = txtUsername.Text,
                password = txtPassword.Text
            });

            this.Hide();
            new FormMain().Show();
        }
    }
}
