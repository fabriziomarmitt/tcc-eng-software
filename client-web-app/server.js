var express = require('express');
var session = require('express-session');
var bodyParser = require('body-parser');
var unirest = require('unirest');
var app = express();

var token = "GQDstcKsx0NHjPOuXOYg5MbeJ1XT0uFiwDVvVBrk";
var assinaturaId = "5907253994c6805ba4e5bf23";

app.use(session({ 
  secret: 'admin@123', 
  cookie: { maxAge: 60000 }
}));

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.use('/public', express.static('public'));

app.get('/', function(req, res) {
    res.sendFile(__dirname + '/src/views/index.html');
    //var sess = req.session;
    //if(!sess.login){
    //    res.redirect("/login");
    //}else{
    //    res.sendFile(__dirname + '/src/views/index.html');
    //}
});

app.post('/api/cancelar', function(req, res) {
    unirest.post('http://localhost:8080/api/v1/assinaturas/assinatura/' + assinaturaId + '/cancelar')
        .headers({'Accept': 'application/json', 'Content-Type': 'application/json'})
        .send(req.body)
        .end(function (response) {
            res.send(response.body);
        });
});

app.post('/api/suspender', function(req, res) {
    unirest.post('http://localhost:8080/api/v1/assinaturas/assinatura/' + assinaturaId + '/suspender')
        .headers({'Accept': 'application/json', 'Content-Type': 'application/json'})
        .send(req.body)
        .end(function (response) {
            res.send(response.body);
        });
});


app.get('/login', function(req, res) {
    if(req.query.token == token){
        req.session.login = true;
        res.redirect("/");
    }else{
        res.sendFile(__dirname + '/src/views/login.html');
    }
});

app.listen(9000, function () {
  console.log("Running at 9000");
});