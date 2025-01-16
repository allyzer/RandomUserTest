package com.allyzer.randomusertest.feature_random_user.presentation.user_list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import com.allyzer.randomusertest.ui.theme.DarkGray

@Composable
fun UserListItem(
    user: User,
    onItemClick: (User) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(user) }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ListItem(
                headlineContent = { Text("${user.first} ${user.last}",) },
                supportingContent = {
                    Text(
                        "${user.streetNumber} ${user.streetName} ${user.city}"
                                + " ${user.state} ${user.country} ${user.postcode}"
                    )
                },
                leadingContent = {
                    AsyncImage(
                        model = user.pictureThumbnail,
                        contentDescription = "avatar",
                        modifier = Modifier.size(48.dp)
                            .clip(CircleShape)
                            .border(1.dp, color = DarkGray, CircleShape),
                        error = painterResource(android.R.drawable.ic_menu_report_image)
                    )
                }
            )
        }
    }
}