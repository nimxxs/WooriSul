// coc view
let newcocbtn = document.querySelector("#newcocbtn");
let modcocbtn = document.querySelector("#modcocbtn");
let rmvcocbtn = document.querySelector("#rmvcocbtn");
let lstcocbtn = document.querySelector("#lstcocbtn");

newcocbtn?.addEventListener('click', ()=>{
    location.href = '/coc/write';
});

lstcocbtn?.addEventListener('click', ()=>{
    location.href = '/coc/list/1';
});

// coc write
let wrtcocbtn = document.querySelector("#wrtcocbtn");

wrtcocbtn?.addEventListener('click', () => {
    let frm = document.forms.cocfrm;

    if (frm.cname.value === '') alert('이름을 작성하세요!!');
    else if (frm.mix.value === '') alert('믹스을 작성하세요!!');
    else if (frm.comment.value === '') alert('코멘트을 작성하세요!!');
    else if (frm.recipe.value === '') alert('레시피을 작성하세요!!');
    else if (frm.base.value === '') alert('레시피을 작성하세요!!');
    else {
        frm.method = 'post';
        frm.enctype = 'multipart/form-data'; // 첨부기능을 위해 추가
        frm.submit();
    }
});

// coc find
let findbtn = document.querySelector("#findbtn");
let findtype = document.querySelector("#findtype");
let findkey = document.querySelector("#findkey");
let backbtn=document.querySelector("#backbtn");

findbtn?.addEventListener('click', () => {
    if (findkey.value === '') alert('검색어를 입력하세요!!');
    else {
        location.href = `/coc/find/${findtype.value}/${findkey.value}/1`;
    }
});


/* view 목록 클릭시 뒤로가기*/
backbtn?.addEventListener('click',()=>{
    location.href = '/coc/list/1';
});