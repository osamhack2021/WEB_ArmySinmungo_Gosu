<template lang="">
  <v-app>
    <v-container>
      <v-row>
        <v-col>
          <v-data-table
            :headers="headers"
            :items="opions"
            :page.sync="page"
            :items-per-page="itemsPerPage"
            hide-default-footer
            class="elevation-1"
            @page-count="pageCount = $event"
          />
        </v-col>
      </v-row>

      <v-row>
        <v-col class="text-center pt-2">
          <v-pagination
            v-model="page"
            :length="pageCount"
          />
        </v-col>
      </v-row>
      <v-row justify="end">
        <v-col
          cols="auto"
        >
          <v-btn
            :to="{path:'/postList/create'}"
          >
            Write
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>

</script>
