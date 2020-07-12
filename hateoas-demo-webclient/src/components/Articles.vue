<template>
	<div>
		<ul>
			<li v-for="article in articles" :key="article.name">
				{{ article.name }} | {{ price(article) }} <span v-html="links(article)"></span>
			</li>
		</ul>
	</div>
</template>
<script>
	export default {
		name: 'Articles',
		props: {
			articles: {
				type: Array,
				required: true
			}
		},
		methods: {
			price(article) {
				return `${article.price} €`
			},
			links(article) {
				if (article.links.length === 0) {
					return 'No links'
				}

				return article.links
					.map(link => `<a href="${link.href}">${link.rel}</a>`)
					.join('| ')
			}
		}
	}
</script>
