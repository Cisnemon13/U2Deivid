<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="6000"
      controls
      indicators
      background="#ababab"
      img-width="30%"
      img-height="60%"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="First slide"
        text="El intellij falló en mi casa profe"
        img-src="https://picsum.photos/1024/480/?image=51"
      ></b-carousel-slide>

      <b-carousel-slide
        caption="Second slide"
        text="Esta indexando el java 17"
        img-src="https://picsum.photos/1024/480/?image=52"
      ></b-carousel-slide>

      <b-carousel-slide
        caption="Third slide"
        text="Micompu es malisima"
        img-src="https://picsum.photos/1024/480/?image=53"
      ></b-carousel-slide>

      <b-carousel-slide
        caption="Fourth slide"
        text="Ya se traboooooooooooooooooooo"
        img-src="https://picsum.photos/1024/480/?image=54"
      ></b-carousel-slide>

    </b-carousel>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        slide: 0,
        sliding: null
      }
    },
    methods: {
      onSlideStart(slide) {
        this.sliding = true
      },
      onSlideEnd(slide) {
        this.sliding = false
      }
    }
  }
</script>