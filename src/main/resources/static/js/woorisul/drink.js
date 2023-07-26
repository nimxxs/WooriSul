// drink list find

// 검색하기 버튼
let findbtn= document.querySelector("#findbtn");
// 검색타입
let searchKind = document.querySelector("#searchKind");
// 검색창
let findkey = document.querySelector("#findkey");

findbtn?.addEventListener('click', ()=> {
    if(findkey.value === '') alert('검색어를 입력하세요');
    else {
        location.href = `/drink/find/${searchKind.value}/${findkey.value}/1`;
        // 검색창 내용: /pds/find/1/title/비가와
    }
});




