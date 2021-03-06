import createView from "../createView.js";

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
        <select>
        	${props.categories.map(category => `<option>${category.name}</option>`)}
		</select>
        <button id="addPost" type="submit">Add Post</button>
    </form>
    <div class="row">
        ${getPostsComponent(props.posts)}
    </div>
</main>
`;
}

function getPostsComponent(posts){
	return posts.map(post => `
        	<div class="post-container card col-4" data-value="${post.id}">
        		<h4>Posted By: ${post.user.username}</h4>
            	<input class="post-title" value="${post.title}"  readonly>
            	<input class="post-content" value="${post.content}" readonly>
            	
            	<div class="categories">
            		${getCategoriesComponent(post.categories)}
				</div>
            	
            	<button class="edit-btn" data-id="${post.id}">Edit Post</button>
            	<button class="delete-btn" data-id="${post.id}">Delete Post</button>
        	</div>
		`).join('');
}

function getCategoriesComponent(categories){

	return categories.map(category => `<span>#${category.name}</span>`).join('');
}

export function PostsEvent() {
	createPost();
	editPost();
	deletePost();
}

function createPost() {
	$("#addPost").on("click", function () {
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

function editPost(){
	$(".edit-btn").click(function(){

		$(".post-title, .post-content").attr("readonly", true);
		$(this).siblings(".post-title, .post-content").attr("readonly", false);
		$(this).text("Save");

		$(this).on("click", submitEditEvent)
	})
}

function submitEditEvent(){

	let post = {
		title: $(this).siblings(".post-title").val(),
		content: $(this).siblings(".post-content").val()
	}

	let request = {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		redirect: 'follow',
		body: JSON.stringify(post)
	}

	let id = $(this).attr("data-id");

	fetch(`http://localhost:8080/api/posts/${id}`, request)
		.then(res => {
			console.log(res.status);
			createView("/posts");
		}).catch(error => {
		console.log(error);
		createView("/posts")
	})

	$(this).off("click", submitEditEvent)

}

function deletePost() {
	$(".delete-btn").on("click", function () {
		$(this).text("Click again to delete");
		let request = {
			method: 'DELETE',
			headers: {
				'Content-Type': 'application/json'
			},
			redirect: 'follow',
		}
		$(this).on("click", function () {
			let id = $(this).attr("data-id");

			fetch(`http://localhost:8080/api/posts/${id}`, request)
				.then(res => {
					console.log(res.status);
					createView("/posts");
				}).catch(error => {
				console.log(error);
				createView("/posts")
			})

			$(this).off("click", fetch);
		})
	})
}





