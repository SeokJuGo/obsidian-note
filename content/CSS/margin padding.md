<img src="../assets/images/CSS/general.png">

![[Pasted image 20240126104311.png]]

**Padding은 Content와 Border 사이의 여백을 나타내는 영역이다**. 
**Margin은** Border 바깥쪽을 차지한다. **주변 요소와 거리를 두기 위한 영역이다.**

https://codepen.io/SeokJuGo/pen/vYPWOgm

```html
<div >
  <p class="a">1</p>
  <p class="a">2</p>
  <p class="a">3</p>
</div>

<style>
	.a{
	background-color: gray;
	margin: 10px;
	width: 100px;
	}
<style/>
```
![[margin.png]]
```html
<div >
  <p class="a">1</p>
  <p class="a">2</p>
  <p class="a">3</p>
</div>
<style>
	.a{
	background-color: gray;
	padding: 10px;
	width: 100px;
	}
<style/>
```
![[padding.png]]