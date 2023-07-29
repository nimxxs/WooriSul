// brewery find 기능
let findofftype = document.querySelector('#findofftype');
let findoffkey = document.querySelector('#findoffkey');
let findoffbtn=document.querySelector('#findoffbtn');
findoffbtn?.addEventListener('click', ()=>{
    if(findoffkey.value ==='') alert('검색어를 입력하세요!');
    else{
        location.href=`/store/offline/find/${findofftype.value}/${findoffkey.value}/1`;
    }
});

function submitName(e) {
    if (e.code === 'Enter') {
        document.getElementById('findoffbtn').click();
    }
};

function goBack() {
    window.history.back();
}

