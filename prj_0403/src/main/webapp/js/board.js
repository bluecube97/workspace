function searchBoardList() {
	//let title = document.querySelector('#title').value;
	//let writernm = document.querySelector('#writernm').value;
	goJava();
}

function goJava() {
	fetch('/board', {
		method: 'POST',
		headers: {
			'Content-Type': "application/json"
		},
		//body: `title=${encodeURIComponent(title)}&writernm=${encodeURIComponent(writernm)}`
	})
		.then(response => {
			if(!response.ok){
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(list => {
			let html = '<ul>';
			list.forEach(item => {
				html += `<li>%{brdNo}: ${item.brdNo}</li>`;
				html += `<li>%{brdTitle}: ${item.brdTitle}</li>`;
				html += `<li>%{userNo}: ${item.userNo}</li>`;
				html += `<li>%{userNm}: ${item.userNm}</li>`;
				html += `<li>%{brdDate}: ${item.brdDate}</li>`;
			});
			html += '</ul>';
			console.log(html);
			document.getElementById("boardList").innerHTML = html;
		})
		.catch(error => console.log('Error: ', error));
}

/*function fillBoardList(list){
	let contentList = document.querySelector('#contentList');
	
	list.forEach(item => {
		let content = document.createElement('content');
		content.brdNo = item.brdNo;
		content.brdTitle = item.brdTitle;
		content.userNo = item.userNo;
		content.userNm = item.userNm;
		content.brdDate = item.brdDate;
		content.skey = item.skey;
		content.soption = item.soption;
		contentList.appendChild(content);
	})
}*/