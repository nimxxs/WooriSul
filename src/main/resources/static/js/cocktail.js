// coc view
let newcocbtn = document.querySelector("#newcocbtn");
let modcocbtn = document.querySelector("#modcocbtn");
let rmvcocbtn = document.querySelector("#rmvcocbtn");
let lstcocbtn = document.querySelector("#lstcocbtn");

newcocbtn?.addEventListener('click', ()=>{
    location.href = '/coc/write';
});

modcocbtn?.addEventListener('click', ()=>{
    if (confirm("정말 수정하시겠어요?")) {
        alert('아직 미지원 기능입니다!!');
    }
});

rmvcocbtn?.addEventListener('click', ()=>{
    if (confirm("정말 삭제하시겠어요?")) {
        alert('아직 미지원 기능입니다!!');
    }
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

/*findbtn?.addEventListener('click', () => {
    if (findkey.value === '') alert('검색어를 입력하세요!!');
    else {
        location.href = `/coc/find/${findtype.value}/${findkey.value}/1`;
    }
});*/

/*
// coc comment
let cmtbtn = document.querySelector("#newcmtbtn");
cmtbtn?.addEventListener('click',()=>{
  let frm = document.forms.cmtfrm;
  if (frm.userid.value === '') alert('로그인 하세요!!');
  else if (frm.pno.value === '') alert('로그인 해!!');
  else if (frm.comments.value === '') alert('댓글을 작성하세요!!');
  else {
      frm.method = 'post';
      frm.action = '/coc/cmt/write';
      frm.submit();
  }
});
// coc reply
let modal = null;
const refno = document.querySelector("#ref");
const showReply = (ref) => {
    refno.value = ref;    // 대댓글을 작성할 댓글의 댓글번호cno를 알아냄
    modal = new bootstrap.Modal(replyModal, {});
    modal.show();
};
const replybtn = document.querySelector("#replybtn");
const frm = document.querySelector("#replyfrm");
replybtn?.addEventListener('click', () => {
    if (frm.comments.value === '') alert('대댓글을 작성하세요!!');
    else if (frm.ref.value === '') alert('댓글번호가 없어요!!');
    else if (frm.pno.value === '') alert('본문글번호가 없어요!!');
    else {
        frm.method = 'post';
        frm.action = '/coc/reply/write';
        frm.submit();
    }
});*/