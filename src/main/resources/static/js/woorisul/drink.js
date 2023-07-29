// drink list find

document.getElementById('pagingForm').addEventListener('submit', function(event) {
    event.preventDefault(); // 기본 form 제출 동작을 중단
    var sname = document.getElementById('findkey').value; // 'name' 값 받아오기
    var region = document.getElementById('searchKind').value; // 'region' 값 받아오기

    // 받아온 값을 사용해 원하는 작업 수행
    // 예: 검색어와 지역이 채워져 있지 않으면 폼 제출 중단
    if (!sname && !region) {
        alert('검색어와 지역을 입력하세요.');
    } else {
        // form 데이터가 필요하면 FormData 인스턴스를 사용
        var formData = new FormData(event.target);
        // formData를 사용해 서버로 데이터 전송
    }
});

$(document).ready(function(){
    $('#layer').click(function(event){
        if(event.target.id == 'layer'){
            $(this).hide();
        }
    });
});

$(document).ready(function(){
    $('.layer-close').click(function(){
        $('#layer').hide();
    });
});



// 목록 눌렀을 때 뒤로가기 구현
function goBack() {
    window.history.back();
}
// 버튼 클릭 이벤트 핸들러
$('.tag_list li button').click(function() {
    // 선택된 버튼의 부모 요소인 li 태그의 id 값을 가져옴
    const id = $(this).parent().attr('id');

    // 선택한 버튼에 active 클래스 추가하여 시각적으로 표시
    $('.tag_list li button').removeClass('active');
    $(this).addClass('active');

    // 선택한 지역 또는 태그를 처리하는 추가적인 로직 구현
    // 이 부분은 사용자의 요구에 따라 개발해야 합니다.
});

// 확인 버튼 클릭 이벤트 핸들러
$('.btn_area a').click(function() {
    // 선택된 지역 또는 태그 정보 가져오기
    const selectedRegion = $('.tag_list.area_list button.active span').text();
    const selectedTag = $('.tag_list.cnt_list button.active span').text();

    // 선택된 정보를 처리하는 추가적인 로직 구현
    // 이 부분은 사용자의 요구에 따라 개발해야 합니다.

    // 예시: 선택된 정보 출력
    console.log('선택된 지역:', selectedRegion);
    console.log('선택된 태그:', selectedTag);
});



// 페이지 번호 클릭 이벤트 핸들러
$('.page_box a').click(function() {
    // 선택된 페이지 번호를 가져옴
    const selectedPage = $(this).attr('id');

    // 선택한 페이지 번호에 active 클래스 추가하여 시각적으로 표시
    $('.page_box a').removeClass('on');
    $(this).addClass('on');

    // 선택한 페이지 번호에 따라 해당 페이지로 이동하는 로직 구현
    // 이 부분은 사용자의 요구에 따라 개발해야 합니다.
});

// 다음 페이지 버튼 클릭 이벤트 핸들러
$('.btn_next').click(function() {
    // 현재 선택된 페이지 번호를 가져옴
    const currentPage = parseInt($('.page_box a.on').attr('id'));

    // 다음 페이지로 이동 (예시로 1페이지부터 5페이지까지만 있는 경우를 가정)
    const nextPage = currentPage + 1;

    // 다음 페이지 번호에 대한 처리 구현
    // 이 부분은 사용자의 요구에 따라 개발해야 합니다.
});

// 마지막 페이지 버튼 클릭 이벤트 핸들러
$('.btn_last').click(function() {
    // 마지막 페이지 번호로 이동 (예시로 1페이지부터 5페이지까지만 있는 경우를 가정)
    const lastPage = 5;

    // 마지막 페이지 번호에 대한 처리 구현
    // 이 부분은 사용자의 요구에 따라 개발해야 합니다.
});



