import addLoginEvent from "../auth";

export default function userView(){
	return `
<header>
    <h1>User Profile</h1>
</header>
<main>
    <div id="user-info">
        <h3>Email</h3>
        
    </div>
    <div class="row">
       
    </div>
</main>
`;
}

function getEmail(user){
	let request = {
		method: "GET",
		headers: {}
	}
	fetch(`http://localhost:8080/api/users/findByEmail?email=${user.getEmail()}`, request)
		.then(res => console.log(res.status))
		.catch(error => console.log(error))
}
