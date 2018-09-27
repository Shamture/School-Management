$(function() {
  
  $("form[name='prof-form']").validate({
   
    rules: {
      cin:{
    	required:true,
    	minlength:8,
    	maxlength:8,
    	digits:true,
    	remote:"test_cin_prof"
      },
      identifiant_uniq:{
    	  required:true,
    	  remote:"test_identifiant"
      },
      nom: {
    	  required:true,
    	  minlength:3,
    	  maxlength:30
      },
      prenom: {
    	  required:true,
    	  minlength:3,
    	  maxlength:30
      },
      email: {
        required: true,  
        email: true
      },
      tel : {
    	required:true,
    	digits:true,
    	minlength:8,
    	maxlength:8
      },
      login:{
    	  required:true,
    	  minlength:4
      },
      password: {
        required: true,
        minlength: 6,
        
      },
      pass_conf:{
     	 equalTo:"#pass" ,
     	 required:true
      }
    },
    
    messages: {
    	cin:{
        	required:"Veuillez entrer le C.I.N",
        	minlength:"Veuillez entrer un C.I.N valide",
        	maxlength:"Veuillez entrer un C.I.N valide",
        	digits:"Veuillez entrer un C.I.N valide",
        	remote:"Ce C.I.N existe deja !"
          },
          identifiant_uniq:{
        	  required:"Veuillez saisir l'identifiant unique",
        	  remote:"Cet identifiant existe deja !"
          },
    	nom: {
    	  required:"Veuillez entrer le nom !",
    	  minlength:"Le nom doit contenir au moin 3 caractere !",
    	  maxlength:"Le nom ne doit pas depasser 30 caractere !"
      },
      prenom: {
    	  required:"Veuillez entrer le prenom !",
    	  minlength:"Le prenom doit contenir au moin 3 caractere !",
    	  maxlength:"Le prenom ne doit pas depasser 30 caractere !"
      },
      tel : {
      	required:"Veuillez saisir le numero telephone",
      	digits:"Veuillez saisir un numero telephone valide",
      	minlength:"Veuillez saisir un numero telephone valide",
      	maxlength:"Veuillez saisir un numero telephone valide"
        },
      password: {
        required: "Veuillez entrer le mot de passe svp !",
        minlength: "Le mot de passe doit au minimum contenir 6 caratere !",
        equalTo: ""
      },
      email: {
    	  required:"Veuillez entrer un email svp !",
    	  email:"Veuillez entrer un email valide !"
      },
      login:{
    	  required: "Veuillez entrer le login !",
    	  minlength:"Le login doit contenir plus que 4 caractere !"
      },
      pass_conf:{
    	 equalTo:"Les deux mots de passe ne sont pas equivalents !",
    	 required:""
      }
    },
   
    submitHandler: function(form) {
      form.submit();
    }
  });
  
  $("form[name='add-eleve-form']").validate({
	   
	    rules: {
	      code_eleve:{
	    	  required : true,
	    	  remote: "test_code_eleve"
	      },
	      nom_eleve: {
	    	  required:true,
	    	  minlength:3,
	    	  maxlength:30
	      },
	      nom_parent: {
	    	  required:true,
	    	  minlength:3,
	    	  maxlength:30
	      },
	      prenom_eleve: {
	    	  required:true,
	    	  minlength:3,
	    	  maxlength:30
	      },
	      prenom_parent: {
	    	  required:true,
	    	  minlength:3,
	    	  maxlength:30
	      },
	      email_eleve: {
	        required: true,  
	        email: true
	      },
	      email_parent: {
		        required: true,  
		        email: true
		      },
	      cin_parent:{    	  
	    	  required: true,
	    	  minlength:8,
	    	  maxlength:8,
	          digits: true
	      },
	      login_parent:{
	    	  required:true,
	    	  minlength:4,
	    	  maxlength:45
	      },
	      password: {
	        required: true,
	        minlength: 6,
	        
	      },
	      pass_conf:{
	     	 equalTo:"#pass" ,
	     	 required:true
	      }
	    },
	    
	    messages: {
	    	code_eleve:{
		    	  required : "Veuillez entrer le code !",
		    	   remote: "Ce code existe deja !"
		      },
		      nom_eleve: {
		    	  required:"Veuillez entrer le nom !",
		    	  minlength:"<i class='fa fa-exclamation-triangle' aria-hidden='true'></i> Le nom doit contenir au moin 3 caractere !",
		    	  maxlength:"Le nom ne doit pas depasser 30 caractere !"
		      },
		      nom_parent: {
		    	  required:"Veuillez entrer le nom !",
		    	  minlength:"Le nom doit contenir au moin 3 caractere !",
		    	  maxlength:"Le nom ne doit pas depasser 30 caractere !"
		      },
		      prenom_eleve: {
		    	  required:"Veuillez entrer le prenom !",
		    	  minlength:"Le nom doit contenir au moin 3 caractere !",
		    	  maxlength:"Le nom ne doit pas depasser 30 caractere !"
		      },
		      prenom_parent: {
		    	  required:"Veuillez entrer le prenom !",
		    	  minlength:"Le nom doit contenir au moin 3 caractere !",
		    	  maxlength:"Le nom ne doit pas depasser 30 caractere !"
		      },
		      email_eleve: {
		        required: "Veuillez entrer un email !",  
		        email: "Veuillez entrer un email valide !"
		      },
		      email_parent: {
		    	  required: "Veuillez entrer un email !",  
			      email: "Veuillez entrer un email valide !"
			  },
		      cin_parent:{    	  
		    	  required: "Veillez entrer le C.I.N",
		    	  minlength:"Veillez entrer un C.I.N valide !",
		    	  maxlength:"Veillez entrer un C.I.N valide !",
		          digits: "Veillez entrer un C.I.N valide !"
		      },
		      login_parent:{
		    	  required:"",
		    	  minlength:"",
		    	  maxlength:""
		      },
		      password: {
		        required: "",
		        minlength: "",
		        
		      },
		      pass_conf:{
		     	 equalTo:"pass" ,
		     	 required:""
		      }
	    },
	   
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
  
  
  
  
  
});
