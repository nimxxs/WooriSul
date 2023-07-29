// brewery find 기능
let findontype = document.querySelector('#findontype');
let findonkey = document.querySelector('#findonkey');
let findonbtn=document.querySelector('#findonbtn');
findonbtn?.addEventListener('click', ()=>{
    if(findonkey.value ==='') alert('검색어를 입력하세요!');
    else{
        location.href=`/store/online/find/${findontype.value}/${findonkey.value}/1`;
    }
});

function submitName(e) {
    if (e.code === 'Enter') {
        document.getElementById('findonbtn').click();
    }
};

function goBack() {
    window.history.back();
}

