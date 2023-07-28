// brewery find 기능
let findtype = document.querySelector('#findtype');
let findkey = document.querySelector('#findkey');
let findbtn=document.querySelector('#findbtn');
findbtn?.addEventListener('click', ()=>{
    if(findkey.value ==='') alert('검색어를 입력하세요!');
    else{
        location.href=`/store/offline/find/${findtype.value}/${findkey.value}/1`;
    }
});

function submitName(e) {
    if (e.code === 'Enter') {
        document.getElementById('findbtn').click();
    }
};

function goBack() {
    window.history.back();
}

