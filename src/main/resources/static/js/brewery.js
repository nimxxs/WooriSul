// brewery find 기능
let findbrtype = document.querySelector('#findbrtype');
let findbrkey = document.querySelector('#findbrkey');
let findbrbtn=document.querySelector('#findbrbtn');
findbrbtn?.addEventListener('click', ()=>{
    if(findbrkey.value ==='') alert('검색어를 입력하세요!');
    else{
        location.href=`/brewery/find/${findbrtype.value}/${findbrkey.value}/1`;
    }
});

function submitName(e) {
    if (e.code === 'Enter') {
        document.getElementById('findbrbtn').click();
    }
};


function goBack() {
    window.history.back();
}

