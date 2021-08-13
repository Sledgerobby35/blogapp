import createView from "../createView";

export default function PostIndex(props) {
	return `
<header>
    <h1>Posts Page</h1>
</header>
<main>
    <form class="create-post">
        <label for="title">Title</label>
        <input type="text" id="title">
        <label for="content">Content</label>
        <input type="text" id="content">
        <button id="addPost" type="submit">Add Post</button>
    </form>
    <div class="row">
        ${props.posts.map(post => `
        <div class="post-container card col-4" data-value="${post.id}">
            <h3>${post.title}</h3>
            <h5>${post.content}</h5>
            <button class="edit-btn" data-id="${id}">Edit Post</button>
            <button class="delete-btn" data-id="${id}">Delete Post</button>
        </div>
        `).join('')}
    </div>
</main>`;
}

export function PostsEvent() {

	createPost();
	editPost();
	deletePost();
}

function createPost() {
	let addBtn = document.getElementById("addPost");
	addBtn.addEventListener("click", function () {

		let post = {
			title: document.getElementById("title").value,
			content: document.getElementById("content").value
		}

		let request = {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			redirect: 'follow',
			body: JSON.stringify(post)
		}

		fetch("http://localhost:8080/api/posts", request)
			.then(res => {
				console.log(res.status);
				createView("/posts");
			}).catch(error => {
			console.log(error);
			createView("/posts");
		});
	});
}

function editPost() {
	let editBtn = document.getElementsByClassName("edit-btn")[`${id}`];
	editBtn.addEventListener("click", function () {
		let post = {
			title: document.getElementById("edit-title")[`${id}`].value,
			content: document.getElementById("edit-content")[`${id}`].value
		}

		let request = {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			redirect: 'follow',
			body: JSON.stringify(post)
		}

		fetch("http://localhost:8080/api/posts/${id}", request)
			.then(res => {
				console.log(res.status);
				createView("/posts");
			}).catch(error => {
			console.log(error);
			createView("/posts");
		});
	});
}

function deletePost() {
	let deleteBtn = document.getElementsByClassName("delete-btn")[`${id}`];
	deleteBtn.addEventListener("click", function () {
		fetch("http://localhost:8080/api/posts/${id}", {
			method: 'DELETE',
		}).then(res => {
			console.log(res.status);
			createView("/posts");
		}).catch(error => {
			console.log(error)
			createView("/posts");
		});
	});
}

function createPostBtn(){
	$("#addPost").on("click", function(){
		let post = {
			title: document.getElementById("title").value,
			content: document.getElementById("content").value
		}

		let request = {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			redirect: 'follow',
			body: JSON.stringify(post)
		}

		fetch("http://localhost:8080/api/posts", request)
			.then(res => {
				console.log(res.status);
				createView("/posts");
			}).catch(error => {
			console.log(error);
			createView("/posts");
		});
	});
}
