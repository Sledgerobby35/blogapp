import createView from "../createView.js";

export default function Register(props){
	return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<form id="register-form">
	<label for="email">Email</label>
	<input id="email" name="email" type="email">
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <input id="submit" type="submit" value="Submit"/>
</form>
</body>
</html>`;
}

export function RegisterEvent(){
	$("#submit").on("click", function(){
		let user = {
			id: 21,
			username: $(this).siblings("#username").val(),
			email: $(this).siblings("#email").val(),
			password: $(this).siblings("#password").val(),
			createdAt: Date.now(),
			role: "USER"
		}

		let request = {
			method: "POST",
			headers: {
				// "Accept" : "application/json",
				"Content-Type": "application/json"},
			body: JSON.stringify(user)
		};

		fetch("http://localhost:8080/api/users/create", request)
			.then((response) => {
				console.log(response.status);
				createView("/");
			});
	});
}