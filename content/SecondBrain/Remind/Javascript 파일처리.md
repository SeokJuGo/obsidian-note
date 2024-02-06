---
제목: 자바스크립트 리마인드
날짜: 2024-02-06
중요도: 상
리마인드: false
---
# 날짜 : 2024-02-06  12:39


# 코드
```javascript
const saveImgFiles = async (e: any) => {  
    console.log(e.target.files);  
    const files: FileList = e.target.files;  
  
    // 여러 파일을 순회하면서 처리  
    Array.from(files).forEach(async (file: File) => {  
        const err = checkImage(file);  
        if (err) {  
            console.log(err);  
            return; // 에러 발생시 해당 파일은 건너뜀  
        }  
  
        // 파일이 유효하다면 미리보기 설정 및 파일 설정  
        await setPreviews(prevFiles => [...prevFiles, URL.createObjectURL(file)]);  
        await setImgFiles(imgFiles => [...imgFiles, file]);  
  
    });  
};

```