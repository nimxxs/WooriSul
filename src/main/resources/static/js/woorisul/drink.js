// drink list find

document.getElementById('pagingForm').addEventListener('text', function(event) {
    event.preventDefault(); // 기본 form 제출 동작을 중단
    var sname = document.getElementById('findkey').value; // 'name' 값 받아오기
    var region = document.getElementById('searchKind').value; // 'region' 값 받아오기

    // 받아온 값을 사용해 원하는 작업 수행
    // 예: 검색어가 비어있지 않으면 폼 제출
    if (sname.trim().length > 0 || region) { // 검색어가 한 글자라도 있거나 지역(region)이 선택되었으면 폼 제출
        // form 데이터가 필요하면 FormData 인스턴스를 사용
        var formData = new FormData(event.target);
        // formData를 사용해 서버로 데이터 전송
    } else {
        alert('검색어를 입력하세요.');
    }
});


document.querySelector('.layer-close').addEventListener('click', function() {
    document.getElementById('layer').style.display = 'none';  // 닫기 버튼을 클릭하면 레이어를 숨깁니다
});

document.getElementById('layer').addEventListener('click', function(event) {
    if(event.target == event.currentTarget) {
        document.getElementById('layer').style.display = 'none';  // 레이어 밖을 클릭하면 레이어를 숨깁니다
    }
});

// 레이어 내부를 클릭해도 레이어가 닫히지 않도록 이벤트 버블링을 방지합니다
document.querySelector('.layer-content').addEventListener('click', function(event) {
    event.stopPropagation();
});


// 목록 눌렀을 때 뒤로가기 구현
function goBack() {
    window.history.back();
}




